package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetII {

    public List<List<Integer>> subsetII(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        backtrackII(resultList, new ArrayList<>(), 0, nums);
        return resultList;
    }

    private void backtrackII(List<List<Integer>> resultList, ArrayList<Integer> tempList, int index, int[] nums) {

        if (resultList.contains(tempList)) resultList.add(new ArrayList<>(tempList));

        resultList.add(new ArrayList<>(tempList));

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrackII(resultList, tempList, i + 1, nums);
            tempList.remove(tempList.size() -1);
        }


    }

}
