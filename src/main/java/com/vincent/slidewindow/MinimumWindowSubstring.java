package com.vincent.slidewindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LeetCode 76 Hard
 * Given two strings, <i>s</i> and <i>t</i>, find the minimum window substring in <i>s</i>, which has the following properties: <br>
 * 1. It is the shortest substring of <i>s</i> that includes all of the characters present in <i>t</i>. <br>
 * 2. It must contain at least the same frequency of each character as in <i>t</i>. <br>
 * 3. The order of the characters does not matter here.
 * Constraint: <br>
 * 1. 1 &lt;= s.length &lt;= 10^5 <br>
 * 2. t.length &lt;= 10^5 <br>
 * 3. s and t consist of English letters. <br>
 */
public class MinimumWindowSubstring {
    // Current test case it will break the 267 test cases on leetcode
    // Overall time complexity: O(m + n x m)
    // space O(1)
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";

        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> wFreq = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
            wFreq.put(c, 0);
        }
        int[] res = {-1, 0, 0};
        int req = tFreq.size();
        int currentReq = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (t.indexOf(currentChar) != -1) {
                wFreq.put(currentChar, wFreq.get(currentChar) + 1);
            }
            // need to match the frequency with t and s
            if (tFreq.containsKey(currentChar) && Objects.equals(wFreq.get(currentChar), tFreq.get(currentChar))) {
                currentReq++;
            }

            // current Req match the required?
            while (currentReq == req) {
                // update the substring stuff first
                if (res[0] == -1 || end - start + 1 < res[0]) {
                    res[0] = end - start + 1;
                    res[1] = start;
                    res[2] = end;
                }
                // shrink the window
                char startChar = s.charAt(start);
                if (t.indexOf(startChar) != -1) {
                    wFreq.put(startChar, wFreq.get(startChar) - 1);
                }
                if (tFreq.containsKey(startChar) && wFreq.get(startChar) < tFreq.get(startChar)) {
                    currentReq--;
                }
                start++;
            }

        }

        return (res[0] == -1) ? "" : s.substring(res[1], res[2] + 1);
    }

    public String minWindowLeetCode(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int left = 0;
        int req = 0;
        int[] wFreq = new int[128]; // s 子串字母的出现次数
        int[] tFreq = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            if (tFreq[c]++ == 0) {
                req++; // 有 less 种字母的出现次数 < t 中的字母出现次数
            }
        }
        for (int right = 0; right < m; right++) { // 移动子串右端点
            char c = s[right]; // 右端点字母（移入子串）
            // update current window frequency
            wFreq[c]++;
            if (wFreq[c] == tFreq[c]) {
                req--; // c 的出现次数从 < 变成 >=
            }
            while (req == 0) { // 涵盖：所有字母的出现次数都是 >=
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                char x = s[left]; // 左端点字母（移出子串）
                left++; // 移动左端点
                if (wFreq[x] == tFreq[x]) {
                    req++; // x 的出现次数从 >= 变成 <
                }
                wFreq[x]--; // 更新当前窗口字母出现次数
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

}
