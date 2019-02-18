package com.learn.leetcode;

import java.util.Arrays;

public class threeSumClosest {
    public static void main(String[] args)  {
        int[] nums = {-3,-2,-5,3,-4};
//        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums ,-1));
    }

    public static int threeSumClosest(int[] nums,int target) {
        Arrays.sort(nums);
        int closestTargetNum;
        if (target >= 0) {
            closestTargetNum = Integer.MAX_VALUE;
        } else {
            closestTargetNum = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int k = target - nums[i];
                int p = i + 1,q = nums.length - 1;
                while (p < q) {
                    if (nums[p] + nums[q] == k) {
                        closestTargetNum = target;
                        break;
                    } else if (nums[p] + nums[q] < k){

                        if (Math.abs(closestTargetNum - target) > Math.abs((nums[p] + nums[q] + nums[i]) - target)) {
                            closestTargetNum = nums[p] + nums[q] + nums[i];
                        }
                        p++;
                    } else {
                        if (Math.abs(closestTargetNum - target) > Math.abs((nums[p] + nums[q] + nums[i]) - target)) {
                            closestTargetNum = nums[p] + nums[q] + nums[i];
                        }
                        q--;
                    }
                }
            }
        }
        return closestTargetNum;
    }

}
