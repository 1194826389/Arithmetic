package com.learn.leetcode;

import java.util.*;

public class generaateParenthesis {
    static LinkedList<String> ans = new LinkedList<String>();
    public static void main(String[] args)  {

        System.out.println(generaateParenthesis(3));

    }

    public static List<String> generaateParenthesis(int n) {

        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;


//        StringBuilder a = new StringBuilder();
//        StringBuilder b = new StringBuilder();
//        int i = n;
//        int j = n;
//        for (int k = 0; k < n * 2; k++) {
//            if ( i == 0) {
//                while (j != 0) {
//                    b.append(")");
//                    j--;
//                }
//                ans.add(a.toString() + b.toString());
//            } else if (i == j) {
//                a.append("(");
//                i--;
//            } else if (i > 0 && j > 0) {
//                if (new Random().nextInt() % 2 == 0) {
//                    a.append("(");
//                    i--;
//                } else {
//                    a.append(")");
//                    j--;
//                }
//            }
//
//        }
//        return ans;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
