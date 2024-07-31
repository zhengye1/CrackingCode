package com.vincent.slidewindow;

import java.util.*;

/**
 * LeetCode 187 - Medium <br>
 * Given a string <i>dna</i> and number <i>k</i>,
 * return all the contiguous subsequences (substrings) of length <i>k</i> that occur more than once in the string.
 * If no repeat return empty set <br>
 * Constraint: <br>
 * 1 &lt;= <i>k</i> &lt;= 10 <br>
 * <i>dna[i]</i> is one of 'A', 'C', 'G', 'T'. <br>
 * 0 &lt;= <i>dna.length</i> &lt;= 10^5 <br>
 * Leetcode version limit the k = 10
 */
public class RepeatDNASequence {

    // Leetcode question only specify k = 10,
    // but we extend to any k value
    // Time: O(n)
    // Space: O(n)
    public Set<String> findRepeatedDnaSequences(String dna, int k) {
        int dnaLength = dna.length();
        if (dnaLength < k)
            return new HashSet<>();
        Map<Character, Integer> dnaHashMap = Map.of('A', 1, 'C', 2, 'G', 3, 'T', 4);
        int base = 4;
        // need array to store each character's hash
        int[] dnaHash = new int[dnaLength];
        //O(n)
        for (int i = 0; i < dnaLength; i++) {
            dnaHash[i] = dnaHashMap.get(dna.charAt(i));
        }
        // initial K window hash
        int currentWindowHash = 0;

        Set<String> resultSet = new HashSet<>();
        Set<Integer> dnaHashSet = new HashSet<>(); // store hash of each window

        // O(n)
        for (int i = 0; i < dnaLength - k + 1; i++) {
            if (i == 0) {
                // O(k) since k < n treat it 1
                for (int j = 0; j < k; j++) {
                    currentWindowHash += (int)(dnaHash[j] * Math.pow(base, k - j - 1));
                }

            } else {
                currentWindowHash = (currentWindowHash - dnaHash[i - 1] * (int)Math.pow(base, k - 1)) * base + dnaHash[i + k - 1];
            }
            if (dnaHashSet.contains(currentWindowHash)) {
                resultSet.add(dna.substring(i, i + k))  ;
            }
            dnaHashSet.add(currentWindowHash);
        }

        return resultSet;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        return new ArrayList<>(findRepeatedDnaSequences(s, 10));
    }
}
