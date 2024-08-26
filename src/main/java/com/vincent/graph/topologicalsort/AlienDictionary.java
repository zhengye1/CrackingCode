package com.vincent.graph.topologicalsort;

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

    }
}
