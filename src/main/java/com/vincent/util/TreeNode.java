package com.vincent.util;

import java.util.Objects;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.data = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(data, treeNode.data) && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + this.data + ", left=" + this.left + ", right=" + this.right + "]";
    }
}
