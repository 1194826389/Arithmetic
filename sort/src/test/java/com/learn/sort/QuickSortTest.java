package com.learn.sort;


import org.junit.Assert;
import org.junit.Test;

import static com.learn.sort.QuickSort.quickSort;
import static com.learn.sort.QuickSort.quickSort2;
import static com.learn.sort.QuickSort.randonQuickSort;
import static org.junit.Assert.*;

public class QuickSortTest {
    int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99};
    int[] b = {45, 12, 4, 6, 89, 12, 34};
    int[] c = {98, 54, 56, 17, 18, 23};

    int[] expectedA = {4, 5, 12, 13, 27, 34, 38, 49, 49, 62, 64, 65, 76, 78, 97, 99};
    int[] expectedB = {4, 6, 12, 12, 34, 45, 89};
    int[] expectedC = {17, 18, 23, 54, 56, 98};
    @Test
    public void quickSortTest() {
        quickSort(a,0,a.length - 1);
        Assert.assertArrayEquals(expectedA,  a);

        quickSort(b,0,b.length - 1);
        Assert.assertArrayEquals(expectedB,  b);

        quickSort(c,0,c.length - 1);
        Assert.assertArrayEquals(expectedC,  c);
    }

    @Test
    public void quickSort2Test() {
        quickSort2(a,0,a.length - 1);
        Assert.assertArrayEquals(expectedA,  a);

        quickSort2(b,0,b.length - 1);
        Assert.assertArrayEquals(expectedB,  b);

        quickSort2(c,0,c.length - 1);
        Assert.assertArrayEquals(expectedC,  c);
    }

    @Test
    public void randonQuickSortTest() {

        randonQuickSort(a,0,a.length - 1);
        Assert.assertArrayEquals(expectedA,  a);

        randonQuickSort(b,0,b.length - 1);
        Assert.assertArrayEquals(expectedB,  b);

        randonQuickSort(c,0,c.length - 1);
        Assert.assertArrayEquals(expectedC,  c);
    }
}