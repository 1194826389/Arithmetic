package com.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    public static void main(String[] args)  {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList();
        Arrays.sort(nums);
        lists.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            System.out.println(lists);
            backtract(lists,nums,i + 1,new ArrayList<Integer>());
        }
        return lists;
    }

    public static void backtract(List<List<Integer>> lists,int[] nums,int k,ArrayList<Integer> tempList) {
        if (tempList.size() == k) {
            lists.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                tempList.add(nums[i]);
                int[] nums1 = Arrays.copyOfRange(nums, i + 1, nums.length);
                backtract(lists,nums1,k,tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
