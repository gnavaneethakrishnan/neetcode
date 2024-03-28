package neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {


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


    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode removedNode = new TreeNode();

        while (!queue.isEmpty()) {
            int level_length = queue.size();

            for (int i = 0; i < queue.size(); i++) {
                removedNode = queue.remove();
                if (i == level_length - 1) results.add(removedNode.val);
            }

            if (removedNode != null) {
                if (removedNode.left != null) {
                    queue.offer(removedNode.left);
                }
                if (removedNode.right != null) {
                    queue.offer(removedNode.right);
                }

            }


        }

        return results;

    }
}