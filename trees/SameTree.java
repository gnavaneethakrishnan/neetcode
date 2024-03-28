package neetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {


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


    public boolean sameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> results = new ArrayList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode pRemovedNode = queue1.poll();
            TreeNode qRemovedNode = queue2.poll();


            if(pRemovedNode == null && qRemovedNode == null) continue;
            if(pRemovedNode == null || qRemovedNode == null) return false;
            if(pRemovedNode.val != qRemovedNode.val) return false;


            if(pRemovedNode.left != null) queue1.offer(p.left);
            if(qRemovedNode.left != null) queue2.offer(q.left);
            if(pRemovedNode.right != null) queue1.offer(p.right);
            if(qRemovedNode.right != null) queue2.offer(q.right);

        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
