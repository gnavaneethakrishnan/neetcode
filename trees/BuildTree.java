package neetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

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


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return splitTree(preorder, inOrderMap,0, 0, inorder.length - 1);

    }

    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderMap,int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = inOrderMap.get(preOrder[rootIndex]);

        if(mid > left) {
            root.left = splitTree(preOrder, inOrderMap, rootIndex + 1, left, mid-1);
        }
        if (mid < right) {
            root.right = splitTree(preOrder, inOrderMap, rootIndex + mid - left + 1, mid + 1, right);
        }

        return root;
    }

}
