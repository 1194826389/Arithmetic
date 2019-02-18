package com.learn.leetcode;

import java.util.*;

public class letterCombinations {
    public static void main(String[] args)  {

        System.out.println(letterCombinations("123"));
    }

    public static List<String> letterCombinations(String digits) {

//        LinkedList<String> ans = new LinkedList<String>();
//        if(digits.isEmpty()) return ans;
//        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        while(ans.peek().length()!=digits.length()){
//            String remove = ans.remove();
//            String map = mapping[digits.charAt(remove.length())-'0'];
//            for(char c: map.toCharArray()){
//                ans.addLast(remove+c);
//            }
//        }
//        return ans;




//        LinkedList<String> ans = new LinkedList<String>();
//        if(digits.isEmpty()) return ans;
//        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        int k = 0;
//        for(int i =0; i<digits.length();i++){
//            int x = Character.getNumericValue(digits.charAt(i));
//            if (x == 1) {
//                continue;
//            }
//            while(ans.peek().length()==k){
//                String t = ans.remove();
//                for(char s : mapping[x].toCharArray())
//                    ans.add(t+s);
//            }
//            k++;
//        }
//        return ans;



        Map<String,String> phoneNumMap;
        phoneNumMap = new HashMap<String, String>(){{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};;

        List<String> lists = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '1') {
                lists.add(phoneNumMap.get(String.valueOf(digits.charAt(i))));
            }
        }
        List<String> result = new ArrayList<String>();
        findConbination(lists,result);
        return result;
    }
    
    
    public static void findConbination(List<String> list,List<String> result) {
        if (list.isEmpty()) return;
        result.clear();
        String l = list.get(0);
        for (int i = 0; i < list.get(0).length(); i++) {
            if (list.subList(1, list.size()).isEmpty()) {
                result.add(String.valueOf(l.charAt(i)));
                continue;
            } else {
                ArrayList<String> result1 = (ArrayList<String>) ((ArrayList<String>)result).clone();
                findConbination(list.subList(1, list.size()), result1);
                for (int j = 0; j < result1.size(); j++) {
                    StringBuilder s = new StringBuilder();
                    s.append(l.charAt(i));
                    s.append(result1.get(j));
                    result.add(s.toString());
                }
            }
        }
    }
}
