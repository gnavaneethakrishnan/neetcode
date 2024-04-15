package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public List<List<Integer>> combinations(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, target, result, new ArrayList<Integer>(),candidates);
        return result;
    }

    private void backtrack(int index, int target, List<List<Integer>> result, ArrayList<Integer> tempList, int[] candidates) {

        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            tempList.add(candidates[index]);
            backtrack(index,target - candidates[index],result,tempList,candidates);
            tempList.remove(tempList.get(tempList.size() - 1));
            backtrack(index+1,target,result,tempList,candidates);
        }

    }


}
