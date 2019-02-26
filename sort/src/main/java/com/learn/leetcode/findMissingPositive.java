package com.learn.leetcode;

import sun.jvm.hotspot.utilities.BitMap;

import java.util.*;

public class findMissingPositive {
    public static void main(String[] args)  {
        int [] array = new int [] {1,2,0};
        System.out.println(firstMissingPositive(array));
    }

    public static int firstMissingPositive(int[] nums) {
//        int min = Integer.MAX_VALUE ;
//        int max = Integer.MIN_VALUE;
//        HashSet set = new HashSet();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                if (nums[i] < min) {
//                    min = nums[i];
//                }
//                if (nums[i] > max) {
//                    max = nums[i];
//                }
//                set.add(nums[i]);
//            }
//        }
//        if (min > 1) return 1;
//        int result = 1;
//        while (min < max) {
//            if (!set.contains(min + 1)) {
//                result = min++;
//                break;
//            }
//        }
//        if (min == max) {
//            result = max + 1;
//        }
//        return result;

        int n = nums.length;
        //遍历每个数字
        for (int i = 0; i < n; i++) {
            //判断交换回来的数字
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                //第 nums[i] 个位置的下标是 nums[i] - 1
                swap(nums, i, nums[i] - 1);
            }
        }
        //找出第一个 nums[i] != i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //如果之前的数都满足就返回 n + 1
        return n + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
