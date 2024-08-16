package com.vincent.util;

import java.util.Objects;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    public boolean visited;
    public LinkedListNode random;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LinkedListNode that = (LinkedListNode)o;
        return data == that.data && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        LinkedListNode copy = this;
        StringBuilder s = new StringBuilder("" + this.data);
        while (copy.next != null) {
            copy.visited = true;
            if (!copy.next.visited) {
                s.append("->").append(copy.next.data);
            }else{
                s.append("->").append(copy.next.data).append("(cycle started)");
                return s.toString();
            }
            copy = copy.next;
        }
        s.append("->").append("null");
        return s.toString();

    }
}
