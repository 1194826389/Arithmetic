package com.learn.leetcode;

import sun.jvm.hotspot.utilities.BitMap;

import java.util.*;

public class findMissingPositive {
    public static void main(String[] args)  {
        int [] array = new int [] {-1,0,2,3,22,0,3,63};
        System.out.println(firstMissingPositive(array));
    }

    public static int firstMissingPositive(int[] nums) {
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        BitSet bitSet = new BitSet(max);
        System.out.println(bitSet.size());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                bitSet.set(nums[i],true);
            }

        }

        int i = 1;
        while (true) {
            if (!bitSet.get(i)) {
                return i;
            } else {
                i++;
            }
        }

    }
}
