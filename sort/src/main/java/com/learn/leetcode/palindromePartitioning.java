package com.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class palindromePartitioning {
    public static void main(String[] args)  {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList();
        backtract(lists, new ArrayList<String>(), s ,0);
        return lists;
    }
    
    
    public static void backtract(List<List<String>> lists,List<String> tempList,String s,int start) {
        if (start == s.length()) {
            lists.add(new ArrayList<String>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s,start, i)) {
                    tempList.add(s.substring(start,i + 1));
                    backtract(lists,tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }

            }
        }
    }


    public static boolean isPalindrome(String x,int left,int right) {
        while (left < right) {
            if (x.charAt(left++) != x.charAt(right--)) return false;
        }
        return true;
    }


//    public List<List<String>> partition(String s) {
//        List<List<String>> list = new ArrayList<>();
//        backtrack(list, new ArrayList<>(), s, 0);
//        return list;
//    }
//
//    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
//        if(start == s.length())
//            list.add(new ArrayList<>(tempList));
//        else{
//            for(int i = start; i < s.length(); i++){
//                if(isPalindrome(s, start, i)){
//                    tempList.add(s.substring(start, i + 1));
//                    backtrack(list, tempList, s, i + 1);
//                    tempList.remove(tempList.size() - 1);
//                }
//            }
//        }
//    }
//
//    public boolean isPalindrome(String s, int low, int high){
//        while(low < high)
//            if(s.charAt(low++) != s.charAt(high--)) return false;
//        return true;
//    }
}
