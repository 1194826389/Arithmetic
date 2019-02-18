package com.learn.leetcode;

public class Reverseinteger {
    public static void main(String[] args)  {
        System.out.println(reverse(1463847422));
    }

    public static int reverse(int x) {
        // Integer scope -2147483648 ~ 2147483647
        long rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x = x/10;
            rev = rev*10 + pop;
        }
        return Math.abs(rev) > Integer.MAX_VALUE ? 0 : (int)rev;
    }
}
