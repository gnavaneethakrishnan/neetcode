package neetcode.twopointers;

import java.util.*;

public class ThreeSum {


    public static List<List<Integer>> threeSumBruteForce(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> solutions = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    // Skip duplicates for k
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums.length <= 2) return new ArrayList<>();

        Set<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length -2; i++) {
            if(nums[i] > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }

            }

        }
        return new ArrayList<>(resultSet);

    }


    public static void main(String[] args) {

        System.out.println(threeSumBruteForce(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));


    }
}
