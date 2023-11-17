package neetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean validAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        Map<Character, Integer> result1 = new HashMap<>();
        Map<Character, Integer> result2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result1.containsKey(c)) {
                result1.put(c, result1.get(c) + 1);
            } else {
                result1.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (result2.containsKey(c)) {
                result2.put(c, result2.get(c)+1);
            } else {
                result2.put(c,1);
            }
        }

        for (Character character : result1.keySet()) {
            if(!result1.get(character).equals(result2.get(character))) {
                return false;
            }
        }

        return true;
    }

    public static boolean validAnagram1(String s, String t) {

        int[] intArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
                intArray[s.charAt(i) - 'a']++;
                intArray[s.charAt(i) - 'a']--;
        }

        for (int count : intArray) {
            if(count != 0) return false;
        }

        return true;
    }

}
