package com.learn.utils;

import java.util.*;

public class Utils {

    public Utils() {

    }

    public static void swap(int[] T, int i, int j) {
        int tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }


    public static void printTopKArray(int[] a, int K) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            if (i == K - 1) {
                System.out.print("      ");
            }
        }
        System.out.println("");
    }


    public static int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            ret[i++] = e;
        }
        return ret;
    }

    // 反转字符串
    public static String reverseString(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverseString(originStr.substring(1)) + originStr.charAt(0);

        /**
         * StringBuilder rev = new StringBuilder();
         *         for (int i = message.length() - 1; i >= 0; i--) {
         *             rev.append(message.charAt(i));
         *         }
         */
    }

    public static void reverseStack(Stack<String> stack) {
        Queue<String> rev = new LinkedList<String>();
        while (stack.size() > 0) {
            rev.offer(stack.pop());
        }

        while (rev.size() > 0) {
            stack.push(rev.poll());
        }
    }

    // 寻找2 ~ n之间的素数
    static List<Integer> findAllPrime(int n)
    {
        List<Integer> allPrime = new ArrayList<Integer>();
        boolean[] a = new boolean[n+1];
        for (int i = 2; i <= n; i++)  a[i] = true;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (a[i])
                for (int j = i; j*i <= n; j++) a[j * i] = false;
        }


        int c = 0;
        for (int i = 0; i <= n; i++)
        {

            if (a[i]) {
                allPrime.add(i);
                System.out.printf(i + "\n");
                c++;
            }
        }
        System.out.printf("素数个数 =" + c + "\n");
        return allPrime;
    }

    // lengthOfMod 必须是2的幂次方
    static int mod(int n,int lengthOfMod) {
        int result = n & (lengthOfMod - 1);
        System.out.println(result);
        return result;
    }


}
