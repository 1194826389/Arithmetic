package com.learn.sort;



// 关于算法的时间复杂度还没看

import com.learn.utils.Utils;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args)  {

        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        randonQuickSort(a,0,a.length - 1);
        Utils.printArray(a);
    }


    /**
     * quickSort 第一种写法
     * @param A 待排序的数组
     * @param p 数组header
     * @param r 数组tailer
     */
    static void quickSort(int[] A,int p,int r) {
        if (p < r) {
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }

    static int partition(int[] A,int p,int r) {
        int baseNum = A[p];
        int i = p;
        int j = r;
        while (i < j) {
            while (i < j && A[j] >= baseNum) {
                j--;
            }
            A[i] = A[j];
            //Utils.printArray(A);

            while (i < j && A[i] <= baseNum) {
                i++;
            }
            A[j] = A[i];
            // Utils.printArray(A);

        }
        A[i] = baseNum;
        //Utils.printArray(A);

        return i;
    }

    /**
     * quickSort 第二种写法：算法导论里的写法
     */
    static void quickSort2(int[] A,int p,int r) {
        if (p < r) {
            int q = partition2(A,p,r);
            quickSort2(A,p,q-1);
            quickSort2(A,q+1,r);
        }
    }

    static int partition2(int[] A,int p,int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                Utils.swap(A, i, j);
            }
        }
        Utils.swap(A, i+1, r);
        return i + 1;
    }

    /**
     * quickSort 第三种写法：算法导论里的随机化版本
     */
    static void randonQuickSort(int[] A,int p,int r) {
        if (p < r) {
            int q = randonPartition(A,p,r);
            randonQuickSort(A,p,q-1);
            randonQuickSort(A,q+1,r);
        }
    }

    static int randonPartition(int[] A,int p,int r) {
        int i = randon(p,r);
        Utils.swap(A, i, r);
        return partition2(A, p, r);


    }

    static int randon(int p,int r) {
        Random random = new Random();
        return random.nextInt(r)%(r - p + 1) + p;
    }
}

