package com.learn;


import java.util.ArrayList;
import java.util.Collections;

public class permutationAndCombination {
    static ArrayList<ArrayList<Integer>> allArr = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args)  {

        func(new ArrayList<Integer>(),0,5);
        for (int i = 0; i < allArr.size(); i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>(allArr.get(i));
            System.out.println("");
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j) + " ");
            }
        }

    }

    static void func(ArrayList<Integer> arr, int i, int n) {

        if (i >= n) {
            ArrayList newArr = new ArrayList(arr);
            allArr.add(newArr);
        } else {
            arr.add(i,1);
            if (check(arr,i)) func(arr, i + 1, n);
            arr.remove(i);
            arr.add(i,0);
            if (check(arr,i))  func(arr,i + 1, n);
            arr.remove(i);

        }

    }

    static boolean check(ArrayList<Integer> arr, int i) {
//        for (int j = 0; j < arr.size(); j++) {
//            System.out.print(arr.get(j) + " ");
//        }
//        System.out.println(" i = " + i);

        if (arr != null && arr.size() >= 3) {
            if (arr.get(i).equals(arr.get(i - 1)) && arr.get(i - 1).equals(arr.get(i - 2))) {
                return false;
            }
        }
        return true;

    }
}
