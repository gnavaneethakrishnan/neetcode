package neetcode.trees;

import java.util.*;
import java.util.stream.IntStream;

public class GoodNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }


    public int goodNodes(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        List<Integer> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        int leftMaxNum = root.val;
        int rightMaxNum = root.val;

        if (root.left != null && root.right != null) {
            if (root.left.val >= leftMaxNum) leftMaxNum = root.left.val;
            if (root.right.val >= rightMaxNum) rightMaxNum = root.right.val;
        } else if (root.left == null) {
            if (root.right.val >= rightMaxNum) {
                rightMaxNum = root.right.val;
                leftMaxNum = root.right.val;
            }
        } else if (root.right == null) {
            if (root.left.val >= leftMaxNum) {
                rightMaxNum = root.left.val;
                leftMaxNum = root.left.val;
            }
        }

        while (!queue.isEmpty()) {

            TreeNode polledNode = queue.poll();
            results.add(polledNode.val);

            if (polledNode.left != null) {
                if (polledNode.left.val >= leftMaxNum) {
                    queue.add(polledNode.left);
                    leftMaxNum = polledNode.left.val;
                }
            }

            if (polledNode.right != null) {
                if (polledNode.right.val >= rightMaxNum) {
                    queue.add(polledNode.right);
                    rightMaxNum = polledNode.right.val;
                }
            }

        }
        int[] resultsArray = results.stream()
                .mapToInt(Integer::intValue).toArray();

        results.stream().forEach(System.out::println);

        return resultsArray.length;

    }


    int count = 0;

    private int goodNodesR(TreeNode root) {

        int max = root.val;
        bfs(root, max);
        return count;

    }

    private void bfs(TreeNode node, int max) {

        if (node.val >= max) {
            max = Math.max(max, node.val);
            count++;
        }

        if (node.right != null)  bfs(node.right, max);
        if (node.left != null)  bfs(node.left, max);

    }

}
