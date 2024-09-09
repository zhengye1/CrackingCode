package com.vincent.prefixtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 1268 - Medium
 * This one have two kind of solution, either using prefix tree or two pointer
 */
public class SuggestSystem {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        LinkedList<String> words = new LinkedList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProductsTrie(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String word : products) {
            insert(word);
        }

        return search(searchWord);
    }

    private void insert(String word) {
        TrieNode now = root;
        for (char c : word.toCharArray()) {
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
            if (now.words.size() < 3) {
                now.words.offer(word);
            }
        }
    }

    private List<List<String>> search(String word) {
        TrieNode now = root;
        List<List<String>> result = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if (now != null)
                now = now.children[c - 'a'];
            result.add((now == null) ? new ArrayList<>() : now.words);
        }
        return result;
    }

    public List<List<String>> suggestedProductsPointer(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0, right = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char current = searchWord.charAt(i);
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != current))
                left++;
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != current))
                right--;
            int remains = right - left + 1;
            List<String> words = new ArrayList<>(Arrays.asList(products).subList(left, Math.min(3, remains) + left));
            result.add(words);
        }
        return result;
    }

    public List<List<String>> suggestProductPointerBinarySearch(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int leftBound = 0, rightBound = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char current = searchWord.charAt(i);
            int l = leftBound, r = rightBound;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (products[mid].length() <= i || products[mid].charAt(i) < current)
                    l = mid + 1;
                else
                    r = mid;
            }
            if (l > r || products[l].length() <= i || products[l].charAt(i) != current) {
                result.add(new ArrayList<>());
                rightBound = leftBound - 1;
                continue;
            }
            leftBound = l;
            r = rightBound;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (products[mid].length() <= i || products[mid].charAt(i) <= current) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            rightBound = r;
            List<String> res = new ArrayList<>(Arrays.asList(products)
                .subList(leftBound, Math.min(3, rightBound - leftBound + 1) + leftBound));
            result.add(res);
        }
        return result;
    }

}
