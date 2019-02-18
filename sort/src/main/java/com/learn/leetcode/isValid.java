package com.learn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid {
    public static void main(String[] args)  {
        isValid("[]");
    }


    public static boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<Character, Character>() {{
            put(']', '[');
            put(')', '(');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if (!stack.isEmpty() && map.get(s.charAt(i)) != null && map.get(s.charAt(i)).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
