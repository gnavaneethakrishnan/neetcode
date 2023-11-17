package neetcode.arrayshashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    private static boolean containsDuplicates(int[] nums) {

        Set<Integer> map = new HashSet<>();

        for (int num : nums) {
            if (!map.add(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicates(new int[] {1,2,3,1}));
    }
}
