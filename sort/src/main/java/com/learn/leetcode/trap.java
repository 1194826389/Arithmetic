package com.learn.leetcode;

public class trap {
    public static void main(String[] args)  {

    }

    public static int trap(int[] A) {

//        int left=0; int right=A.length-1;
//        int res=0;
//        int maxleft=0, maxright=0;
//        while(left<=right){
//            if(A[left]<=A[right]){
//                if(A[left]>=maxleft) {
//                    maxleft=A[left];
//                } else {
//                    res+=maxleft-A[left];
//                }
//                left++;
//            }
//            else{
//                if(A[right]>=maxright) {
//                    maxright= A[right];
//                } else {
//                    res+=maxright-A[right];
//                }
//                right--;
//            }
//        }
//        return res;

        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            if (leftmax < A[a]) leftmax = A[a];
            if (rightmax < A[b]) rightmax = A[b];
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;

//        int max = Integer.MIN_VALUE;
//        int maxIndex = 0;
//        int sum3 = 0;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] > max) {
//                max = A[i];
//                maxIndex = i;
//            }
//            sum3 = sum3 + A[i];
//        }
//
//
//        int[] lefttoMax = A.clone();
//        int preMax = 0;
//        int[] righttoMax = A.clone();
//        int lastMax = 0;
//        for (int i = 0,j = righttoMax.length - 1; i < lefttoMax.length || j > 0; i++,j--) {
//            if (i == 0) {
//                preMax = lefttoMax[i];
//            } else {
//                if (lefttoMax[i] < preMax) {
//                    lefttoMax[i] = preMax;
//                } else if (lefttoMax[i] >= preMax){
//                    preMax = lefttoMax[i];
//                }
//            }
//            if (j == righttoMax.length - 1) {
//                lastMax = righttoMax[righttoMax.length - 1];
//            } else {
//                if (righttoMax[j] < lastMax) {
//                    righttoMax[j] = lastMax;
//                } else if (righttoMax[j] >= lastMax){
//                    lastMax = righttoMax[j];
//                }
//            }
//        }
//
//        int sum1 = 0;
//        int sum2 = 0;
//        for (int i = 0,j = A.length - 1; i < maxIndex || j > maxIndex; i++,j--) {
//            sum1 = sum1 + max - lefttoMax[i];
//            sum2 = sum2 + max - righttoMax[j];
//        }
//        return max * A.length - sum1 - sum2 - sum3;
    }
}
