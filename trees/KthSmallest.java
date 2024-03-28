package neetcode.trees;

import java.util.LinkedList;
import java.util.List;

public class KthSmallest {


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

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public int KthSmallest(TreeNode root, int k) {

        List<Integer> inOrderList = new LinkedList<>();
        helper(root, inOrderList);
        Integer result = inOrderList.get(k);
        return result;
    }

    private void helper(TreeNode root, List<Integer> inOrderList) {

        if (root.left != null || root.right != null) {
            helper(root.left, inOrderList);
            inOrderList.add(root.val);
            helper(root.right, inOrderList);

        }
    }


}
