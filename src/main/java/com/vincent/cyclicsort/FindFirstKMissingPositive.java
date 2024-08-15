package com.vincent.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, find the first k missing positive numbers
 */
public class FindFirstKMissingPositive {
    public List<Integer> findFirstKMissingPositives(int[] arr, int k){
        if (arr.length == 0) return List.of(1);

        for (int i = 0; i < arr.length; i++) {
            // swap them on the correct position
            while(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]){
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        int  i;
        List<Integer> missing = new ArrayList<>();
        Set<Integer> other = new HashSet<>();
        for (i = 0; i < arr.length && missing.size() < k; i++) {
            if (arr[i] != i + 1){
                missing.add(i + 1);
                other.add(arr[i]);
            }
        }

        for (int j = i;  missing.size() < k; j++) {
            if (!other.contains(j + 1)) missing.add(j + 1);
        }
        return missing;
    }
}
