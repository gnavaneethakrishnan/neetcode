package neetcode.trees;

import java.util.*;

public class SerializeBinaryTree {



    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }



    public String serializeDFS(TreeNode root) {
        List<String> preOrderList = new LinkedList<>();
        helper(root, preOrderList);
        String coded = String.join(",", preOrderList);
        System.out.println(coded);
        return coded;
    }

    private void helper(TreeNode root, List<String> results) {

        if (root == null) {
            results.add("N");
            return;
        }

        results.add(String.valueOf(root.val));
        helper(root.left, results);
        helper(root.right, results);
    }

    public String serialize(TreeNode root) {
        if(root == null) return "N";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder results = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode polled = queue.poll();
            if (polled != null) {
                results.append(String.valueOf(polled.val) +",");
                queue.offer(polled.left);
                queue.offer(polled.right);
            } else results.append("N,");

        }

        return results.toString();

    }


    public TreeNode deserialize(String data) {

        if(data == "N") return null;
        String[] tokens = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        queue.add(root);

        for (int i = 1; i < tokens.length; i++) {
            TreeNode parent = queue.poll();
            if (!tokens[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(tokens[i]));
                parent.left = left;
                queue.add(left);
            }
            if (!tokens[++i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(tokens[i]));
                parent.right = right;
                queue.add(right);

            }


        }

            return root;

    }



        }



