package neetcode.arrayshashing;

import java.util.*;

public class KMostFrequentElements {

    private static int[] topFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        //this data type to create a bucket, seems to be different, let us check this out
        List<Integer>[] bucket = new List[nums.length+1];

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }

        //now i need to get the top two max numbers from the values

        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<Integer>();
            }
                bucket[frequency].add(key);
        }


        int[] response = new int[k];
        int counter = 0;

        for (int position = bucket.length - 1; position >= 0 && counter < k; position--) {
            if (bucket[position] != null) {
                for (int num:bucket[position]) {
                    response[counter] = num;
                    counter = counter + 1;
                }
            }
        }
        return response;
    }


    private static int[] topFrequentHeap(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        int[] result = new int[k];

        for (int num: nums) {
            map.put(num,map.getOrDefault(num,0) +1);
        }

        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) pq.poll();

        }

        int i = k;
        while(!pq.isEmpty()) {
            result[--i] = pq.poll().getKey();
        }

        return result;




    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(topFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        int[] arr = {10, 20, 30, 40};


    }
}
