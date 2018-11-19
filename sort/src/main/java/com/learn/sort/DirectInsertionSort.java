package com.learn.sort;

import com.learn.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 直接插入排序，希尔排序，简单选择排序，冒泡排序，归并排序，基数排序
 * Created by hechao on 2017/6/12.
 */
public class DirectInsertionSort {
    public static void main(String[] args) {
//        simpleSelectionSort();
//        bubbleSort();
//        new MergingSort();
        new RadixSort();
        return;
    }

    /**
     * 直接插入排序
     */
    public static void directInsertionSort() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = temp;
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort() {
        int a[] = {1, 54, 6, 3, 78, 34, 12, 45, 56, 100};
        double d1 = a.length;
        int temp = 0;

        while (true) {
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {

                for (int i = x + d; i < a.length; i += d) {
                    int j = i - d;
                    temp = a[i];
                    for (; j >= 0 && temp < a[j]; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }

            if (d == 1) {
                break;
            }
            System.out.println(Arrays.toString(a));
        }

    }


    /**
     * 简单选择排序
     */
    public static void simpleSelectionSort() {
        int a[] = {1, 54, 6, 3, 78, 34, 12, 45};
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i + 1;
            position = i;
            int temp = a[i];
            for (; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort() {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }



    /**
     * 归并排序
     */
    public static class MergingSort {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        public MergingSort() {
            sort(a, 0, a.length - 1);
        }

        public void sort(int[] data, int left, int right) {
            // TODO Auto-generatedmethod stub
            if (left < right) {
                //找出中间索引
                int center = (left + right) / 2;
                //对左边数组进行递归
                sort(data, left, center);
                //对右边数组进行递归
                sort(data, center + 1, right);
                //合并
                merge(data, left, center, right);
            }

        }

        public void merge(int[] data, int left, int center, int right) {
            // TODO Auto-generatedmethod stub
            int[] tmpArr = new int[data.length];
            int mid = center + 1;
            //third记录中间数组的索引
            int third = left;
            int tmp = left;
            while (left <= center && mid <= right) {
                //从两个数组中取出最小的放入中间数组
                if (data[left] <= data[mid]) {
                    tmpArr[third++] = data[left++];
                } else {
                    tmpArr[third++] = data[mid++];
                }

            }

            //剩余部分依次放入中间数组
            while (mid <= right) {
                tmpArr[third++] = data[mid++];
            }

            while (left <= center) {
                tmpArr[third++] = data[left++];
            }

            //将中间数组中的内容复制回原数组
            while (tmp <= right) {
                data[tmp] = tmpArr[tmp++];
            }
            System.out.println(Arrays.toString(data));
        }
    }

    /**
     * 基数排序
     */
    public static class RadixSort {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 101, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        public RadixSort() {
            sort(a);

            System.out.println(Arrays.toString(a));

        }

        public void sort(int[] array) {
            //首先确定排序的趟数;
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            int time = 0;
            //判断位数;
            while (max > 0) {
                max /= 10;
                time++;
            }

            //建立10个队列;
            List<ArrayList> queue = new ArrayList<ArrayList>();
            for (int i = 0; i < 10; i++) {
                ArrayList<Integer> queue1 = new ArrayList<Integer>();
                queue.add(queue1);
            }

            //进行time次分配和收集;
            for (int i = 0; i < time; i++) {
                //分配数组元素;
                for (int j = 0; j < array.length; j++) {
                    //得到数字的第time+1位数;
                    int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                    ArrayList<Integer> queue2 = queue.get(x);
                    queue2.add(array[j]);
                    queue.set(x, queue2);
                }
                int count = 0;//元素计数器;
                //收集队列元素;
                for (int k = 0; k < 10; k++) {
                    while (queue.get(k).size() > 0) {
                        ArrayList<Integer> queue3 = queue.get(k);
                        array[count] = queue3.get(0);
                        queue3.remove(0);
                        count++;
                    }
                }
            }
        }
    }

}
