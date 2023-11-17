package neetcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {




    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> storeMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complementaryNum = target - num;
            if(!storeMap.containsKey(complementaryNum)) {
                storeMap.put(num,i+1);
            } else {
                Integer j = storeMap.get(complementaryNum);
                return new int[] {j,i+1};
            }
        }

        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        int i = 0;
        int j= nums.length -1;
        while (i < j) {
            if(nums[i] + nums[j] > target) {
                j--;
            } else if(nums[i] + nums[j] < target) {
                i++;
            } else {
                return new int[] {i+1,j+1};
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum(new int[]{20,30,40},60)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0},-1)));

        System.out.println(Arrays.toString(twoSum2(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{20,30,40},60)));
        System.out.println(Arrays.toString(twoSum2(new int[]{-1,0},-1)));
    }
}
