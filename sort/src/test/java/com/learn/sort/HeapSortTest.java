package com.learn.sort;

import org.junit.Assert;
import org.junit.Test;

import static com.learn.sort.HeapSort.heapSort;
import static com.learn.sort.QuickSort.quickSort;


public class HeapSortTest {
    int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99};
    int[] b = {45, 12, 4, 6, 89, 12, 34};
    int[] c = {98, 54, 56, 17, 18, 23};

    int[] expectedA = {4, 5, 12, 13, 27, 34, 38, 49, 49, 62, 64, 65, 76, 78, 97, 99};
    int[] expectedB = {4, 6, 12, 12, 34, 45, 89};
    int[] expectedC = {17, 18, 23, 54, 56, 98};

    @Test
    public void heapSortTest() {
        heapSort(a);
        Assert.assertArrayEquals(expectedA,  a);

        heapSort(b);
        Assert.assertArrayEquals(expectedB,  b);

        heapSort(c);
        Assert.assertArrayEquals(expectedC,  c);
    }
}