package com.vincent.prefixtree;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 208 - Medium
 * Implement a trie
 */
public class Trie {
    static class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode now = this.root;
        for (char c : word.toCharArray()) {
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode now = this.root;
        for (char c : word.toCharArray()) {
            if (now.children[c - 'a'] == null) return false;
            now = now.children[c - 'a'];
        }
        return now.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean searchPrefix(String prefix) {
        TrieNode now = this.root;
        for (char c : prefix.toCharArray()) {
            if (now.children[c - 'a'] == null) return false;
            now = now.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> keys = Arrays.asList("the", "a", "there", "answer");
        Trie trieOfKeys = new Trie();
        int num = 1;
        for (String x : keys) {
            System.out.println(num + ".\tInserting key: '" + x + "'");
            trieOfKeys.insert(x);
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        List<String> search = Arrays.asList("a", "answer", "xyz", "an");
        for (String y : search) {
            System.out.println(num + ".\tSearching key: '" + y + "'");
            System.out.println("\tKey found? " + trieOfKeys.search(y));
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        List<String> searchPrefix = Arrays.asList("b", "an");
        for (String z : search) {
            System.out.println(num + ".\tSearching prefix: '" + z + "'");
            System.out.println("\tPrefix found? " + trieOfKeys.searchPrefix(z));
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
