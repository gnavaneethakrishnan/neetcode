package neetcode.trees;

import java.util.*;

public class InvertTree {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;


        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode invertTreeUsingRecursion(TreeNode root) {

        if(root == null) return null;

        TreeNode left = invertTreeUsingRecursion(root.left);
        TreeNode right = invertTreeUsingRecursion(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        TreeNode currentNode = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode removedNode = queue.poll();
            swapNodes(removedNode);
            if (removedNode.left != null) {
                queue.add(removedNode.left);
            }

            if (removedNode.right != null) {
                queue.add(removedNode.right);
            }

        }


        return root;

    }


    private void swapNodes(TreeNode currentNode) {
        TreeNode temp = currentNode.left;
        currentNode.left = currentNode.right;
        currentNode.right = temp;

    }


    public int depth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int numOfLevels = -1;

        while (true) {

            int nodeCountAtLevel = queue.size();

            if (nodeCountAtLevel == 0) {
                return numOfLevels;
            }

            while (nodeCountAtLevel > 0) {
                TreeNode polledNode = queue.poll();
                if (polledNode.left != null) queue.offer(polledNode.left);
                if (polledNode.right != null) queue.offer(polledNode.right);
                nodeCountAtLevel--;
            }

            numOfLevels++;

        }


    }

    public int diameter(TreeNode root) {

        Map<TreeNode, Integer> depthMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {

            TreeNode node = stack.peek();

            if (node.left != null & !depthMap.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !depthMap.containsKey(node.right)) {
                stack.push(node.right);
            } else {

                stack.pop();

                int leftDepth = depthMap.getOrDefault(node.left, 0);
                int rightDepth = depthMap.getOrDefault(node.right, 0);

                depthMap.put(node, 1 + Math.max(leftDepth, rightDepth));

                diameter = Math.max(diameter, leftDepth + rightDepth);


            }


        }

        return diameter;

    }



}

