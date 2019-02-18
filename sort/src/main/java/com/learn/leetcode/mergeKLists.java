package com.learn.leetcode;


public class mergeKLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args)  {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(6);
        listNode6.next = listNode7;

        ListNode[] listNodes = {listNode,listNode3,listNode6};
        ListNode sortedListNode = mergeKLists(listNodes);
        ListNode prev = sortedListNode;
        while (prev != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }


    }

    public static ListNode mergeKLists(ListNode[] lists) {

        return mergeLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeLists(ListNode[] lists,int i,int j) {
        if (i == j) {
            return lists[i];
        }
        if (i < j) {
            int middle = (i + j) / 2;
            ListNode l1 = mergeLists(lists, i,  middle);
            ListNode l2 = mergeLists(lists, middle + 1, j);
            return mergeTwoLists(l1, l2);

        } else {
            return null;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // merge into new ListNode
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;

                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 != null) {
            prev.next = l1;
        }

        if (l2 != null) {
            prev.next = l2;
        }
        return head.next;
    }


}

