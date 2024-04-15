package neetcode.trees;

public class MaxPathSum {


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


        int max = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
         depthFirstSearch(root);
         return max;



    }

    private int depthFirstSearch(TreeNode root) {

        if(root == null) return 0;

        int left = Math.max(depthFirstSearch(root.left),0);
        int right = Math.max(depthFirstSearch(root.right),0);
        max = Math.max(max, left + right + root.val);
        return Math.max(left,right) + root.val;
    }

}
