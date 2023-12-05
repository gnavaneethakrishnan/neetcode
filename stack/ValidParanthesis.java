package neetcode.stack;

import java.util.List;
import java.util.Stack;

public class ValidParanthesis {

    public static boolean isValid(String s) {

        if (s.isEmpty()) return false;

        if(s.length() % 2 != 0) return false;

        Stack<Character> newStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if(newStack.isEmpty() && s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                return false;
            } else if (s.charAt(i) == '}' && newStack.peek() == '{') newStack.pop();
              else if (s.charAt(i) == ')' && newStack.peek() == '(') newStack.pop();
              else if (s.charAt(i) == ']' && newStack.peek() == '[') newStack.pop();
              else {
                  newStack.push(s.charAt(i));
            }

        }
        return newStack.isEmpty();
    }
}
