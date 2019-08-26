package com.learn.leetcode;

public class containerWithMostWater {
    public static void main(String[] args)  {
        int[] a = {1,7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0,j = height.length - 1; i < j;){
            int x;
            if (height[i] <= height[j]) {
                if (max < height[i] * (j - i)) {
                    max = height[i] * (j - i);
                }
                i++;
            } else {
                if (max < height[j] * (j - i)) {
                    max = height[j] * (j - i);
                }
                j--;
            }
        }
        return max;
    }
}
