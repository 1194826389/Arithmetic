package com.learn;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class kmp {

    static String p = "abaabcac";
    static char[] chars = p.toCharArray();
    static int len = p.length();
    static int[] next = new int[len];

    static {
//        int k=0,i=1;
//        next[0] = 0;
//        while (i< len - 1) {
//            if (chars[i] == chars[k]) {
//                i++;k++;
//                next[i] = k;
//
//            } else if (k == 0) {
//                next[i++] = 0;
//            } else {
//                k = next[k - 1];
//            }
//        }


        int j = 1,k = 0;
      next[0] = 0;

      while (j < len - 1) {
          if (k == 0 || chars[j] == chars[k]) {
              j++;
              k++;
              next[j] = k;
          } else {
              k = next[k];
          }
      }

//        for (int o = 0; o < len; o++) {
//            System.out.println(next[o]);
//        }


    }

    public static void main(String[] args)  {
//        System.out.println(KMP("acabaabaabcacaabc","abaabcac",0));
        System.out.println(KMP("bbbfasdfasdbbbbabctabcabctabctaaaaa","abctabcabctabct",0));

    }



    static private int KMP(String S, String T, int pos) {
        int i = pos; int j = 0;
        char[] SC = S.toCharArray();
        char[] TC = T.toCharArray();


        while(i < S.length() && j < T.length()) {
            if (j == 0 || SC[i] == TC[j]) {
                ++i;++j;
            } else {
                j = next[j];
            }
        }
        if (j == T.length()) return i - T.length();
        return 0;
    }
}
