package neetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthClosestPoint {

    public int[][] kClosest(int[][] points, int k) {

        //how do i substract each of the values from center

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );

        //number of results required is two and each has 2 values (pointers)
        int[][] results = new int[k][2];

        for (int[] point : points) pq.add(point);

        /*int count = 0;
        while (k > 0) {
            results[count] = pq.poll();
            count++;
            k--;
        }*/

        for (int i = 0; i < k; i++) {
            int[] current = pq.poll();
            results[i][0] = current[0];
            results[i][1] = current[1];

        }

        return results;
    }

    public static void main(String[] args) {

        int[][] twoDimensional = new int[2][1];
        twoDimensional = new int[][]{
                {1,11},
                {2,12},
                {3,13}
        };

        System.out.println(Arrays.deepToString(twoDimensional));
    }


}
