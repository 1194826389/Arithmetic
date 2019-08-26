package com.learn.leetcode;




public class RemoveNthNodeFromEndofList {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode t = head.next;
            head.next = newHead;
            newHead = head;
            head = t;
        }
        return newHead;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = reverseList(head);
        ListNode dummy = new ListNode(0);
        dummy.next = newHead;
        int i = 1;
        ListNode first = dummy;
        while (i < n) {
            i++;
            first = first.next;
        }
        first.next = first.next.next;

        return reverseList(dummy.next);
    }

    public static void main(String[] args)  {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(removeNthFromEnd(listNode, 2));
    }


}
