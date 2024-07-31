package com.vincnet.twopointer;

import com.vincent.twopointer.ReverseWordInSentence;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordTest {
    ReverseWordInSentence reverseWordInSentence = new ReverseWordInSentence();
    List<String> stringsToReverse = Arrays.asList(
            "Hello World",
            "a   string   with   multiple   spaces",
            "Case Sensitive Test 1234",
            "a 1 b 2 c 3 d 4 e 5",
            "     trailing spaces",
            "case test interesting an is this"
    );

    @Test
    void testCase1(){
        assertEquals("World Hello", reverseWordInSentence.reverseWords(stringsToReverse.get(0)));
    }
    @Test
    void testCase2(){
        assertEquals("spaces multiple with string a", reverseWordInSentence.reverseWords(stringsToReverse.get(1)));
    }
    @Test
    void testCase3(){
        assertEquals("1234 Test Sensitive Case", reverseWordInSentence.reverseWords(stringsToReverse.get(2)));
    }
    @Test
    void testCase4(){
        assertEquals("5 e 4 d 3 c 2 b 1 a", reverseWordInSentence.reverseWords(stringsToReverse.get(3)));
    }
    @Test
    void testCase5(){
        assertEquals("spaces trailing", reverseWordInSentence.reverseWords(stringsToReverse.get(4)));
    }
    @Test
    void testCase6(){
        assertEquals("this is an interesting test case", reverseWordInSentence.reverseWords(stringsToReverse.get(5)));
    }
}
