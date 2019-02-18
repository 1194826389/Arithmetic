package com.learn.leetcode;

public class StringToInteger {
    public static void main(String[] args)  {
        System.out.println(myAtoi("a-2147483647"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int i = 0, ans = 0, sign = 1, len = str.length();
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '+' ? 1 : -1;
        for (; i < len; ++i) {
            int tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9)
                break;
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                ans = ans * 10 + tmp;
        }
        return sign * ans;
//        if (str == null) {
//            return 0;
//        }
//        str = str.trim();
//        if (str.isEmpty()) {
//            return 0;
//        }
//
//        long value = 0;
//        char[] strArr = str.toCharArray();
//        int k = 0;
//        boolean isMinus = false;
//        while (k < strArr.length) {
//
//            char c = strArr[k];
//            if (k == 0) {
//                if (checkMinus(c)) {
//                    isMinus = true;
//                } else if (checkInteger(c)) {
//                    value = value * 10 + c - 48;
//                } else if (!checkPlus(c)){
//                    return 0;
//                }
//            } else {
//                if (isMinus) {
//                    if (checkInteger(c)) {
//                        value = getMinusValue(value, c);
//                    } else {
//                        return k == 1 ? 0 : (int)value;
//                    }
//                } else {
//                    if (checkInteger(c)) {
//                        value = getPlusValue(value, c);
//                    } else {
//                        return (int)value;
//                    }
//                }
//
//            }
//            k++;
//        }
//        return (int) value;
    }

    private static long getPlusValue(long value, char c) {
        value = value * 10 + (c - 48);
        if (value > Integer.MAX_VALUE) {
            value = Integer.MAX_VALUE;
        }
        return value;
    }

    private static long getMinusValue(long value, char c) {
        value = value * 10 - (c - 48);
        if (value < Integer.MIN_VALUE) {
            value = Integer.MIN_VALUE;
        }
        return value;
    }

    public static boolean checkInteger(char v) {
        int x = (int) v - 48;
        if (x <= 9 && x >= 0) {
            return true;
        }
        return false;
    }

    public static boolean checkMinus(char v) {
        if (v == '-') {
            return true;
        }
        return false;
    }

    public static boolean checkPlus(char v) {
        if (v == '+') {
            return true;
        }
        return false;
    }

}
