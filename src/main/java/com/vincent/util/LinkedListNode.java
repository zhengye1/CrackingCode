package com.vincent.util;

import java.util.Objects;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListNode that = (LinkedListNode) o;
        return data == that.data && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

//    @Override
//    public String toString() {
//        LinkedListNode copy = this;
//        StringBuilder s = new StringBuilder("" + this.data);
//        while (copy.next != null) {
//            s.append("->").append(copy.next.data);
//            copy = copy.next;
//        }
//        return s.toString();
//    }
}
