package com.vincent.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46 - Medium
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length - 1, result);
        return result;
    }

    public void permute(int[] nums, int left, int right, List<List<Integer>> result) {
        if (left == right) {
            List<Integer> pair = new ArrayList<>();
            for (int num : nums) {
                pair.add(num);
            }
            result.add(pair);
        }else{
            for (int i = left; i <= right; i++) {
                swap(nums, left, i);
                permute(nums, left + 1, right, result);
                swap(nums, left, i);
            }
        }

    }

    public List<String> permute(String word){
        List<String> result = new ArrayList<>();
        permute(word.toCharArray(), 0, word.length() - 1, result);
        return result;
    }

    public void permute(char[] chaArray, int left, int right, List<String> result){
        if (left == right){
            result.add(new String(chaArray));
        }else{
            for (int i = left; i <= right; i++){
                swap(chaArray, left, i);
                permute(chaArray, left + 1, right, result);
                swap(chaArray, left, i);
            }
        }
    }

    public void swap(char[] charArray, int i, int j){
        // swap the char array
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    public void swap(int[] num, int i, int j){
        // swap the char array
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args){
        new Permutation().permute(new int[]{1,2,3});
    }
}
