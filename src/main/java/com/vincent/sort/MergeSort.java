package com.vincent.sort;

public class MergeSort {
    public void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2) return ;
        int mid = length >> 1;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int l = 0, r = 0, index = 0;
        while (l < leftSize && r < rightSize) {
            if (left[l] <= right[r]) {
                arr[index++] = left[l++];
            }else{
                arr[index++] = right[r++];
            }
        }

        while (l < leftSize) {
            arr[index++] = left[l++];
        }
        while (r < rightSize) {
            arr[index++] = right[r++];
        }
    }
}
