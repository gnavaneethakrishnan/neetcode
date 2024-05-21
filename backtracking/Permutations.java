package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return permute(list);
    }

    private List<List<Integer>> permute(List<Integer> nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums.size() == 1) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>(nums));
            return base;
        }

        for (int i = 0; i < nums.size(); i++) {
            Integer n = nums.remove(0);
            List<List<Integer>> perms = permute(nums);
            perms.forEach(perm -> perm.add(n));
            result.addAll(perms);
            nums.add(n);
        }

        return result;
    }

}



