package com.vincent.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 17 - Medium
 * Give a digit, find all the combination for the string that on the phoen keyboard
 */
public class LetterCombination {
    List<String> res = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return res;
        }
        // create a telephone map
        String[] phoneMaps = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, phoneMaps, 0);
        return res;
    }

    private void backtracking(String digits, String[] phoneMaps, int num) {
        if (num == digits.length()) {
            res.add(str.toString());
        }else{
            String letters = phoneMaps[digits.charAt(num) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                str.append(letters.charAt(i));
                backtracking(digits, phoneMaps, num + 1);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
