package com.vincent.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 438 - Medium
 * Given a string <i>s</i> and a string <i>p</i>, return all the index if <i>p</i> is anagram in <i>s</i>
 */
public class FindAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) return result;
        int[] pCount = frequencyCount(p, pLen);
        int[] sCount = frequencyCount(s, pLen - 1); // only count the first pLen at the beginning
        for (int i = 0; i < sLen - pLen + 1; i++) {
            sCount[s.charAt(i + pLen - 1) - 'a']++; //把右边窗口的加进来
            if (Arrays.equals(sCount, pCount)) result.add(i);
            sCount[s.charAt(i) - 'a']--; // 把左边的窗口丢出去
        }
        return result;
    }

    private int[] frequencyCount(String s, int right) {
        int[] frequency = new int[26];
        for (int i = 0; i < right; i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        return frequency;
    }
}
