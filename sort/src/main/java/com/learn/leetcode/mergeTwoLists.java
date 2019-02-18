package com.learn.leetcode;


public class mergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args)  {
        ListNode listNode = new ListNode(1);


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // merge into new ListNode
//        ListNode head = new ListNode(0);
//        ListNode prev = head;
//        while (l1!=null && l2!=null) {
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//
//        if (l1!=null) {
//            prev.next =l1;
//        }
//
//        if (l2!=null) {
//            prev.next = l2;
//        }
//        return head.next;


//        // a recursive solution
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//
//        if(l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l2.next, l1);
//            return l2;
//        }


        // merge into l1
        ListNode head = new ListNode(0);
        ListNode prev = head;
        prev.next = l1;

        while (l1!=null && l2!=null) {
            if (l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            } else {
                // l2 前进一步
                ListNode temp = l2;
                l2 = l2.next;
                // 将temp加入到l1中来
                temp.next = l1;
                prev.next = temp;
                prev = temp;
            }
        }

        if (l2!=null) {
            prev.next = l2;
        }
        return head.next;
    }
}
