package neetcode.heap;

import java.util.PriorityQueue;

public class FindKthLargest {

    public int findKthLargest(int nums[], int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
                queue.add(num);
            }
        int extrasAdded = nums.length - k;

        while (extrasAdded > 0) {
            queue.poll();
            extrasAdded--;
        }

        return queue.peek();

    }

    public int findKthLargestAnother(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1-n2);

        for(int n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
