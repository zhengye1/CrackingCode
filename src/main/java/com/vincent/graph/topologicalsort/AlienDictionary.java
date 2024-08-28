package com.vincent.graph.topologicalsort;

import java.util.Arrays;

/**
 * LeetCode 269 - Hard
 * LeetCode 953- Easy
 */
public class AlienDictionary {
    // LeetCode 953, provide the words and order
    // return true if words in dictionary order
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        char[] orderArray = order.toCharArray();
        for (int i = 0; i < orderArray.length; i++) {
            orderIndex[orderArray[i] - 'a'] = i;
        }

        // because just compare two adjacent
        for (int i = 0; i < words.length - 1; i++) {
            char[] current = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int c = 0, n = 0;
            for (; c < Math.min(current.length, next.length) || n < Math.min(current.length, next.length); c++, n++) {
                if (current[c] == next[n]) continue;
                if (orderIndex[current[c] - 'a'] > orderIndex[next[n] -'a']) return false;
                if (orderIndex[current[c] - 'a'] < orderIndex[next[n] -'a']) break;
            }
            // current one is not process all the character
            if (c < current.length && n == next.length) return false;
        }
        return true;
    }

    public String alienOrder(String[] words) {
        int[] head = new int[26];
        int[] next = new int[52];
        int[] to = new int[52];
        int cnt = 0;
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        Arrays.fill(to, -1);
        Arrays.fill(head, -1);
        Arrays.fill(next, -1);

        // record letter
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                indegree[word.charAt(j) - 'a'] = 0;
            }
        }

        for(int i = 0; i < words.length - 1;i++){
            char[] currentWord = words[i].toCharArray();
            char[] nextWord = words[i + 1].toCharArray();
            int j = 0, len = Math.min(currentWord.length, nextWord.length);
            for (;j < len; j++) {
                if (currentWord[j] != nextWord[j]) {
                    // we found the edge
                    to[cnt] = nextWord[j] - 'a';
                    next[cnt]= head[currentWord[j] - 'a'];
                    head[currentWord[j] - 'a'] = cnt++;
                    indegree[nextWord[j] - 'a']++;
                    break;
                }
            }
            if (j < currentWord.length && j == nextWord.length) return "";
        }
        StringBuilder ans = new StringBuilder();
        int l = 0, r = 0;
        int kinds = 0; // how many letter we have
        int[] queue = new int[26];
        for (int i = 0; i < 26; i++) {
            if (indegree[i] != -1) kinds++;
            if (indegree[i] == 0) queue[r++] = i;
        }
        while (l < r){
            int current = queue[l++];
            ans.append((char) (current + 'a'));
             for (int ei = head[current]; ei >= 0; ei = next[ei]){
                indegree[to[ei]]--;
                if (indegree[to[ei]] == 0) queue[r++] = to[ei];
            }
        }
        return ans.length() == kinds ? ans.toString() : "";
    }


}
