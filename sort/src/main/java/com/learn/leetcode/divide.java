package com.learn.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

public class divide {
    public static void main(String[] args)  {
        System.out.println(divide(Integer.MIN_VALUE,-1));
    }

    public static int divide(int dividend , int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MIN_VALUE;
        }
        long dvd = dividend;
        dvd = Math.abs(dvd);
        long dvs = divisor;
        dvs = Math.abs(dvs);
        long ans = 0;
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        while (dvd >= dvs) {
            long temp = dvs, m = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            ans += m;
        }
        return (int) (sign * ans);
//        if (dividend == Integer.MIN_VALUE && divisor == 1) {
//            return Integer.MIN_VALUE;
//        }
//
//
//        int sign = 1; // 正数
//        if (!(dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0)) {
//            sign = -1;
//        }
//        long positiveDividend = dividend;
//        positiveDividend = Math.abs(positiveDividend);
//        long positiveDivisor = divisor;
//        positiveDivisor = Math.abs(positiveDivisor);
//        if (positiveDividend < positiveDivisor) {
//            return 0;
//        } else if (positiveDividend == positiveDivisor) {
//            return sign;
//        } else {
//            long temDivisor = positiveDivisor;
//            long i = 0;
//            while (temDivisor <= positiveDividend) {
//                i++;
//                temDivisor = positiveDivisor + temDivisor;
//            }
//            if (i > Integer.MAX_VALUE) {
//                return Integer.MAX_VALUE;
//            }
//            return (int) (sign > 0 ? i : -i);
//        }
    }
}
