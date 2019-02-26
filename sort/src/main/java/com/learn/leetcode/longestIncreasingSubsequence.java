package com.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class longestIncreasingSubsequence {
    public static void main(String[] args)  {
        int[] dp = {10,9,2,5,3,7,101,18};
        lengthOfLIS(dp);

    }

    public static int lengthOfLIS(int[] nums) {
        // 还有一种 动态规划，和longestPalindromeString 一起看看
        // binarySearch
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;

//        // binarySearch
//        int[] dp = new int[nums.length];
//        int len = 0;
//        for(int x : nums) {
//            int i = binarySearch(dp, 0, 0, 10);
//            if(i < 0) i = -(i + 1);
//            dp[i] = x;
//            if(i == len) len++;
//        }
//        return len;

//        // backtract 时间复杂度为n！
//        List<Integer> list = new ArrayList();
//        List<Integer> tempList = new ArrayList();
//        backTrack(nums,list , tempList, 0);
//        System.out.println(list);
//        return list.size();



    }


    private static int binarySearch(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static void backTrack(int[] nums, List<Integer> list, List<Integer> tempList, int start) {
        if (start == nums.length) {
            if (list.size() == 0 || list.size() < tempList.size()) {
                list.clear();
                list.addAll(tempList);
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                if (tempList.size() == 0 || nums[i] > tempList.get(tempList.size() - 1)) {
                    tempList.add(nums[i]);
                    backTrack(nums,list, tempList, i +1);
                    if (list.size() == nums.length) {
                        return;
                    }
                    tempList.remove(tempList.size() - 1);
                }
                if (i == nums.length - 1) {
                    if (list.size() == 0 || list.size() < tempList.size()) {
                        list.clear();
                        list.addAll(tempList);
                    }
                }
            }
        }
    }
}
