package com.vincent.slidewindow;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatDNASequenceTest {
    RepeatDNASequence repeatDNASequence = new RepeatDNASequence();
    String[] input =
        {"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "AAAAAAAAAAAAA", "AA", "ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
            "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
            "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT"};
    int[] k = {10, 10, 10, 3, 3, 8, 12, 10, 14, 10, 6};

    @Test
    void testCase1() {
        // test LeetCode version
        int testCase = 0;
        List<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase]);
        List<String> expected = List.of("AAAAACCCCC", "CCCCCAAAAA");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }

    @Test
    void testCase2() {
        // test LeetCode version
        int testCase = 1;
        List<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase]);
        List<String> expected = List.of("AAAAAAAAAA");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }

    @Test
    void testCase3() {
        // test LeetCode version
        int testCase = 2;
        List<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase]);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testCase4() {
        int testCase = 3;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        assertTrue(actual.isEmpty());
    }

    @Test
    void testCase5() {
        int testCase = 4;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        Set<String> expected = Set.of("GAC", "AGA");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }

    @Test
    void testCase6() {
        int testCase = 5;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        Set<String> expected = Set.of("AAAAACCC", "AAACCCCC", "AAAACCCC");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }

    @Test
    void testCase7() {
        int testCase = 6;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        Set<String> expected = Set.of("GGGGGGGGGGGG");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }

    @Test
    void testCase8() {
        int testCase = 7;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        Set<String> expected =
            Set.of("TTTTCCCCCC", "CCCCTTTTTT", "TTCCCCCCCT", "CCCCCCCTTT", "TTTCCCCCCC", "TCCCCCCCTT", "CCCCCTTTTT",
                "TTTTTCCCCC", "CCCCCCTTTT");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }

    @Test
    void testCase9() {
        int testCase = 8;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        assertTrue(actual.isEmpty());
    }
    @Test
    void testCase10() {
        int testCase = 9;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        Set<String> expected =
            Set.of("AAAAACCCCC", "AAAAAACCCC", "AAACCCCCCC", "AAAACCCCCC");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }
    @Test
    void testCase11() {
        int testCase = 10;
        Set<String> actual = repeatDNASequence.findRepeatedDnaSequences(input[testCase], k[testCase]);
        Set<String> expected =
            Set.of("ATATAT", "TATATA");
        for (String s : actual) {
            assertTrue(expected.contains(s));
        }
    }
}
