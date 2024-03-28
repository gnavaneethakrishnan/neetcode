package neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeCountAtlevel = queue.size();
            List<Integer> order = new ArrayList<>();

            while (nodeCountAtlevel > 0) {

                TreeNode removedNode = queue.poll();
                if (removedNode != null) order.add(removedNode.value);
                nodeCountAtlevel--;

                if (removedNode != null) {

                    if (removedNode.left != null || removedNode.right != null) {
                        queue.offer(removedNode.left);
                        queue.offer(removedNode.right);
                    }

                }

                results.add(order);
            }

        }

        return results;
    }

}