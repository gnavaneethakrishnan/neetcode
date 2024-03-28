package neetcode.trees;

public class BalancedTree {

    class TreeNode {

        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }

    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);


    }


    private int height(TreeNode currentNode) {

        if (currentNode == null) return 0;

        return 1 + Math.max(height(currentNode.left), height(currentNode.right));


    }


    private int[] balanceFactor(TreeNode current) {

        if(current == null) return new int[]{0, 1};

        int[] leftBalancedFactor = balanceFactor(current.left);
        int[] rightBalancedFactor = balanceFactor(current.right);

        if (leftBalancedFactor[1] == 0 || rightBalancedFactor[1] == 0) return new int[]{0, 0};

        if ( Math.abs(leftBalancedFactor[0] - rightBalancedFactor[0]) > 1) {
            return new int[]{0, 0};
        }

        return new int[]{ Math.max(leftBalancedFactor[0], rightBalancedFactor[0] + 1), 1 };


    }
}
