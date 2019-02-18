package com.learn.leetcode;

public class median {
    public static void main(String[] args)  {
            int[] nums1 = {1,2};int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        Boolean isEven;
        if (totalLength%2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
        int median = totalLength/2;
        int[] nums3 = new int[totalLength];
        int k=0;
        int i = 0;
        int j = 0;
        while(i< nums1.length&&j<nums2.length){
            if(nums1[i] > nums2[j]) {
                nums3[k] = nums2[j++];
            } else {
                nums3[k] = nums1[i++];
            }
            double x = findMedian(isEven, median, nums3, k);
            if (x != -1) return x;
            k++;
        }

        while (i < nums1.length){
            nums3[k] = nums1[i++];
            Double x = findMedian(isEven, median, nums3, k);
            if (x != null) return x;
            k++;
        }

        while (j < nums2.length) {
            nums3[k] = nums2[j++];
            Double x = findMedian(isEven, median, nums3, k);
            if (x != null) return x;
            k++;
        }

        return 0;
    }

    private static double findMedian(Boolean isEven, int median, int[] nums3, int k) {
        if (k == median) {
            if (isEven == true) {
                return (double)(nums3[k] + nums3[k-1])/2;
            } else {
                return nums3[k];
            }
        }
        return Double.MIN_VALUE;
    }

}
