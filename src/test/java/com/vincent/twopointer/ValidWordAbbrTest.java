package com.vincent.twopointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidWordAbbrTest {
    String[] words = {"a", "a", "abcdefghijklmnopqrst", "abcdefghijklmnopqrst", "word", "internationalization", "localization"};
    String[] abbreviations = {"a", "b", "a18t", "a19t", "wtestCaserd", "i18n", "l12n"};
    ValidWordAbbr validWordAbbr = new ValidWordAbbr();

    @Test
    void testCase1() {
        assertTrue(validWordAbbr.validWordAbbreviation(words[0], abbreviations[0]));
    }

    @Test
    void testCase2() {
        assertFalse(validWordAbbr.validWordAbbreviation(words[1], abbreviations[1]));
    }

    @Test
    void testCase3() {
        assertTrue(validWordAbbr.validWordAbbreviation(words[2], abbreviations[2]));
    }

    @Test
    void testCase4() {
        assertFalse(validWordAbbr.validWordAbbreviation(words[3], abbreviations[3]));
    }

    @Test
    void testCase5() {
        assertFalse(validWordAbbr.validWordAbbreviation(words[4], abbreviations[4]));
    }

    @Test
    void testCase6() {
        assertTrue(validWordAbbr.validWordAbbreviation(words[5], abbreviations[5]));
    }

    @Test
    void testCase7() {
        assertFalse(validWordAbbr.validWordAbbreviation(words[6], abbreviations[6]));
    }
}
