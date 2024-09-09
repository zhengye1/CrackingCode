package com.vincent.util;

public class TrieNode {
    public TrieNode[] children;
    public boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        TrieNode now = this;
        for (char c : word.toCharArray()) {
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.isEnd = true;
    }
}
