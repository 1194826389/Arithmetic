package com.learn.leetcode;

import java.util.LinkedList;

public class StackList<E> {
    LinkedList<E> list;

    public StackList(){
        list = new LinkedList<E>();
    }

    public E pop() {
        return list.removeLast();
    }

    public E peek() {
        return list.peekLast();
    }

    public void push(E e) {
        list.add(e);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
