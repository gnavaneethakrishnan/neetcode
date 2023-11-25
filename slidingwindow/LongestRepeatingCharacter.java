package neetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {

    public static int characterReplacement(String s, int k) {

        int maxLength = 0;
        int topFrequency = 0;

        Map<Character, Integer> keyFreq = new HashMap<>();


        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            keyFreq.put(rightChar, keyFreq.getOrDefault(rightChar, 0) + 1);
            topFrequency = Math.max(topFrequency, keyFreq.get(rightChar));

            while ((right - left + 1) - topFrequency > k) {
                char leftChar = s.charAt(left);
                int i = keyFreq.get(leftChar) - 1;
                keyFreq.put(leftChar, i);
                left++;
            }

            maxLength = Math.max(maxLength, (right - left + 1));

            right++;

        }

        return maxLength;

    }


    public static void main(String[] args) {

        System.out.println(characterReplacement("ABABA", 1));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
