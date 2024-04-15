package neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stone : stones) {
            heap.add(stone);
        }

        while (heap.size() > 0) {
            if (heap.size() == 1) {
                return heap.peek();
            }
            int x = heap.poll();
            int y = heap.poll();
            if (x != y) {
                x = x - y;
                heap.add(x);
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> result = new PriorityQueue<>(
                (a, b) -> b - a
        );

        int[] nums = {2, 7, 4, 1, 8, 1};
        for (int num : nums) {
            result.add(num);
        }

        Integer num1 = result.poll();
        Integer num2 = result.poll();
        System.out.println(num1);

    }
}
