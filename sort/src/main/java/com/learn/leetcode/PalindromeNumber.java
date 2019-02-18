package com.learn.leetcode;

public class PalindromeNumber {
    public static void main(String[] args)  {
        System.out.println(isPalindrome(100100101));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }


        StackList<Integer> firstStackList = new StackList();
        StackList<Integer> secondStack = new StackList();
        while (x != 0) {
            firstStackList.push(x%10);
            x = x/10;
        }

        int len = firstStackList.size();
        if (len == 2) {
            if (firstStackList.pop().equals(firstStackList.pop())) {
                return true;
            } else {
                return false;
            }
        }
        int middle = len/2;
        int i = len - 1;
        while(!firstStackList.isEmpty()) {
            if (i > middle) {
                secondStack.push(firstStackList.pop());
            } else if (i == middle) {
                if (len % 2 == 0) {
                    secondStack.push(firstStackList.pop());
                } else {
                    firstStackList.pop();
                    i--;
                    continue;
                }
            } else {
                if (!secondStack.pop().equals(firstStackList.pop())) {
                    return false;
                }
            }
            i--;
        }
        return true;



    }
}
