package neetcode.heap;

import java.util.PriorityQueue;

public class MedianFinderHeapSol {

  /*  PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;


    public MedianFinderHeapSol() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        small.offer(num);

        if (!large.isEmpty() && small.peek() >= large.peek()) {
            large.offer(small.poll());
        }

        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        } else return (small.peek() + large.peek()) / 2.0;*/

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinderHeapSol() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        // Balance the heaps
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }

}
