package neetcode.trees;

public class SubTree {

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


    public boolean isSubTree(TreeNode root, TreeNode subRoot) {

        if (root == null) return false;
        return (isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot) || isSameTree(root, subRoot));

    }


    private boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if (p.val != q.val) return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
    }


}
