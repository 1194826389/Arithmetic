package com.learn.leetcode;

public class search {
    public static void main(String[] args)  {
        int[] nums = {2,1};
        int target = 1;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums,int target) {
        if (nums.length > 0) {
            if (target >= nums[0]) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                    if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                        break;
                    }
                }
            } else {
                for (int i = nums.length - 1; i > 0; i--) {
                    if (nums[i] == target) {
                        return i;
                    }
                    if (i - 1 > 0 && nums[i] < nums[i - 1]) {
                        break;
                    }
                }
            }
        }
        return -1;

    }
}
