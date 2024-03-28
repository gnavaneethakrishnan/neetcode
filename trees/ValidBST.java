package neetcode.trees;

import java.util.LinkedList;
import java.util.List;

public class ValidBST {

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

        TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean isValidBST(TreeNode root) {
//        if(root == null) return;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);

    }


    public boolean isBST(TreeNode root) {

        List<Integer> inOrderList = new LinkedList<>();
        helper(root, inOrderList);

        boolean isBST = true;
        int prev = inOrderList.get(0);

        for (int i = 1; i < inOrderList.size(); i++) {
            if(inOrderList.get(i) <= prev) isBST = false;
            prev = inOrderList.get(i);
        }

        return isBST;
    }

    private void helper(TreeNode treeNode, List<Integer> inOrderList) {

        if (treeNode == null) return;

        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);

    }


}




