package neetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class UniqueLongSubString {


    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int length = 0;

        Set<Character> seen = new HashSet<>();

        int i = 0;
        int j = i;
        while (j < s.length()) {
            char c = s.charAt(j);
            if(seen.add(c)) {
                length = (j - i) + 1;
                j++;

            } else {
                seen.remove(s.charAt(i));
                i++;
                maxLength = Math.max(length,maxLength);

            }
        }

        return Math.max(length,maxLength);

    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("au"));

    }
}
