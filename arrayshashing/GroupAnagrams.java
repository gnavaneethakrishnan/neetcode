package neetcode.arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : strings) {
            String strKey = makeStringKey(str);
            if (resultMap.containsKey(strKey)) {
                resultMap.get(strKey).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                resultMap.put(strKey,list);
            }
        }

        return new ArrayList<>(resultMap.values());
    }

    private static String makeStringKey(String str) {

        //frequency bucket
        int[] freq = new int[26];

        //counting the number of chars in each bucket
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder freqString = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        System.out.println(freqString);
        return freqString.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

