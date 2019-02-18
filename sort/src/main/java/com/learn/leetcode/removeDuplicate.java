package com.learn.leetcode;

public class removeDuplicate {
    public static void main(String[] args)  {
        int[] a = {1,1,1,1,2,3,3,3,4,4,5,6};
        System.out.println(removeDuplicate(a));
        System.out.println(a[2]);

    }

    public static int removeDuplicate(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                len++;
            } else {
                if (nums[i] != nums[i - 1]) {
                    nums[len] = nums[i];
                    len++;
                }
            }
        }
        return len;

    }
}
