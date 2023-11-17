package neetcode.arrayshashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutive {


    public static int longestConsecutiveTimeLimitExceeded(int[] nums) {

        HashMap<Integer, Boolean> resultMap = new HashMap<>();

        for (int num : nums) resultMap.put(num, Boolean.FALSE);

        int sequenceCount = 0;

        for (int num : nums) {

            int currentLength = 1;
            int nextNum = num + 1;

            while (resultMap.containsKey(nextNum) && resultMap.containsValue(nextNum) == Boolean.FALSE) {
                resultMap.put(num, Boolean.TRUE);
                currentLength++;
                nextNum++;
            }

            int prevNum = num - 1;
            while (resultMap.containsKey(prevNum) && resultMap.containsValue(prevNum) == Boolean.FALSE) {
                resultMap.put(num, Boolean.TRUE);
                currentLength++;
                prevNum--;
            }

            sequenceCount = Math.max(sequenceCount, currentLength);

        }

        return sequenceCount;
    }


    public static int longestConsective(int[] nums) {

        if(nums.length == 0) return 0;

        HashMap<Integer, Boolean> resultMap = new HashMap<>();

        for (int num : nums) resultMap.put(num, Boolean.FALSE);

        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            int nextNum = nums[i] + 1;

            int numSequenceCount = 1;

        while(resultMap.containsKey(nextNum) && resultMap.get(nextNum) == Boolean.FALSE ) {
            numSequenceCount++;
            resultMap.put(nextNum, Boolean.TRUE);
            nextNum++;
        }

        int prevNum = nums[i] -1;

        while(resultMap.containsKey(prevNum) && resultMap.get(prevNum) == Boolean.FALSE ) {
            numSequenceCount++;
            resultMap.put(prevNum, Boolean.TRUE);
            prevNum--;
        }

        longest = Math.max(longest,numSequenceCount);

    }

        return longest;
}

    public static int longestSequence(int[] nums) {

        if (nums.length == 0) return 0;

        Set<Integer> result = new HashSet<>();

        for (int num : nums) {
            result.add(num);
        }
        int longest = 1;

        for (int num : nums) {
            if(!result.contains(num -1)) {
                int count =  1;
                while(result.contains(num + 1)) {
                    count++;
                    num++;
                }
            longest = Math.max(count,longest);
            }
        }
        return longest;

    }

    public static void main(String[] args) {

        System.out.println(longestConsecutiveTimeLimitExceeded(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveTimeLimitExceeded(new int[]{0,3,7,2,5,8,4,6,0,1}));

        System.out.println(longestConsective(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsective(new int[]{0,3,7,2,5,8,4,6,0,1}));

        System.out.println(longestSequence(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestSequence(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }




}
