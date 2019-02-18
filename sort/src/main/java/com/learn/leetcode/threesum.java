package com.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesum {
    public static void main(String[] args)  {
        int[] a = {-3,-2,-5,3,-4};
//        int[] a = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threesum(a,0);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> threesum(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int k =  target - nums[i];
                int p = i + 1;
                int q = len - 1;
                while (p < q) {
                    if (nums[p] + nums[q] == k) {
                        l.add(Arrays.asList(nums[i], nums[p], nums[q]));
                        while (p < q && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        p++;
                        while (p < q && nums[q] == nums[q - 1]) {
                            q--;
                        }
                        q--;
                    } else if (nums[p] + nums[q] < k) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }
        return l;
//        Arrays.sort(nums);
//        List<List<Integer>> l = new ArrayList<List<Integer>>();
//        int len = nums.length;
//        for (int i = 0; i < len - 2; i++) {
//            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
//                int target = -1 * nums[i];
//                int p = i + 1; int q = len - 1;
//                while (p < q) {
//                    if (nums[p] + nums[q] == target) {
//                        l.add(Arrays.asList(nums[i],nums[p++],nums[q--]));
//                        while (p < q && nums[p] == nums[p+1]) {
//                            p++;
//                        }
//                        while (p < q && nums[q] == nums[q-1]) {
//                            q--;
//                        }
//                        p++;q--;
//                    } else if (nums[p] + nums[q] < target) {
//                        p++;
//                    } else {
//                        q--;
//                    }
//                }
//            }
//        }
//        return l;

//        Arrays.sort(num);
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        for (int i = 0; i < num.length-2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                        while (lo < hi && num[lo] == num[lo+1]) lo++;
//                        while (lo < hi && num[hi] == num[hi-1]) hi--;
//                        lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) lo++;
//                    else hi--;
//                }
//            }
//        }
//        return res;
    }
}
