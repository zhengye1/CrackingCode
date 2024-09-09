package com.vincent.prefixtree;

import com.vincent.util.TrieNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 648 - Medium
 */
public class ReplaceWord {
    public String replaceWordsTrie(List<String> dictionary, String sentence) {
        // Build the proper prefix tree first
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            root.insert(word);
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = replaceHelper(words[i], root);
        }
        return String.join(" ", words);
    }

    private String replaceHelper(String word, TrieNode root) {
        TrieNode current = root;
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            current = current.children[c - 'a'];
            if (current == null)
                return word;
            result.append(c);
            if (current.isEnd)
                return result.toString();
        }
        return (result.isEmpty()) ? word : result.toString();
    }

    public String replaceWordNonTrie(List<String> dictionary, String sentence) {
        return Arrays.stream(sentence.split(" "))
            .map(s -> dictionary.stream().filter(s::startsWith).min(Comparator.comparingInt(String::length)).orElse(s))
            .collect(Collectors.joining(" "));
    }
}
