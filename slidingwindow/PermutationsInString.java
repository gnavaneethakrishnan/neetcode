package neetcode.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationsInString {

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> mapCharCount = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            mapCharCount.put(c, mapCharCount.getOrDefault(c, 0) + 1);

        }
        int left = 0;
        int right = 0;

        while (right < s2.length()) {

            char currentCharacter = s2.charAt(right);
            mapCharCount.put(currentCharacter, mapCharCount.getOrDefault(currentCharacter, 0) - 1);

            while (mapCharCount.get(currentCharacter) < 0) {
                char leftChar = s2.charAt(left);
                mapCharCount.put(leftChar, mapCharCount.getOrDefault(leftChar, 0) + 1);
                left++;
            }

            //how to calculate window size and move left pointer
            //how to compare that there is perumatations

            if (right - left + 1 == s1.length()) {
                return true;
            }
            right++;

        }
        return false;

    }



    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

}
