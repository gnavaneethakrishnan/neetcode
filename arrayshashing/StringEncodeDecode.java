package neetcode.arrayshashing;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeDecode {


    public static String encode(String[] strs) {

        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            encodedString.append(length).append("#").append(str);

        }

        return encodedString.toString();
    }


    public static List<String> decode(String str) {

        ArrayList<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
                int j = i;
                while(str.charAt(j) != '#') j++;
                    int length = Integer.parseInt(str.substring(i,j));
                    i = j + 1 + length;
                    decodedStrings.add(str.substring(j+1,i));

        }
        return decodedStrings;

    }




    public static void main(String[] args) {

        System.out.println(encode(new String[]{"lint", "code", "love", "you"}));
        System.out.println(decode("4#lint4#code4#love3#you"));

    }
}
