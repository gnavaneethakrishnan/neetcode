package neetcode.backtracking;

import generics.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<Integer>(), nums, 0);
        return resultList;

    }

    private void backtrack(List<List<Integer>> resultSets, ArrayList<Integer> tempSet, int[] nums, int start) {
        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resultSets,tempSet,nums,i+1);
            tempSet.remove(tempSet.size() - 1);
        }
    }

}

