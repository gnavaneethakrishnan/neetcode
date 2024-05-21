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


    public List<List<Integer>> subsetsNeetCodeSol(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempSet = new ArrayList<>();
        dfs(result,nums,0,tempSet);
        return result;


    }

    private void dfs(List<List<Integer>> result, int[] nums, int i, List<Integer> tempSet) {

        if (i >= nums.length) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        tempSet.add(nums[i]);
        dfs(result,nums,i+1,tempSet);
        tempSet.remove(tempSet.size() - 1);
        dfs(result,nums,i+1,tempSet);
    }


}

