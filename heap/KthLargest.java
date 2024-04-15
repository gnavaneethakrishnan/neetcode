package neetcode.heap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            heap.add(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }

        }


    public int add(int val) {



        if (heap.size() < k) {
            heap.add(val);
        } else if (val > heap.peek()) {
                heap.poll();
                heap.add(val);
            }

        return heap.peek();

    }

    // create a heap data structure of size 3 when constructing the object
    // when adding re-order the heap i.e. remove the existing one if it is not within kthlargest and return the kthlargest
    // how to create a heap data structure for a array of integers

}


