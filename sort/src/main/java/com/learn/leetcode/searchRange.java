package com.learn.leetcode;

public class searchRange {
    public static void main(String[] args)  {
        int[] nums = new int[] {0,0};
        int[] resultindex = searchRange(nums, 1);
        System.out.println(resultindex[0] + ":" + resultindex[1]);
    }
    
    public static int[] searchRange(int[] nums,int target) {
        //for simple search
//        int start = -1;
//        int end = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                start = i;
//                while (i < nums.length && nums[i] == target) {
//                    i++;
//
//                }
//                end = i - 1;
//            }
//        }
//        int[] range = new int[]{-1,-1};;
//        if (start != -1) {
//            range = new int[]{start,end};;
//        }
//        return range;


        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(nums, target + 1) - 1};
    }

    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}
