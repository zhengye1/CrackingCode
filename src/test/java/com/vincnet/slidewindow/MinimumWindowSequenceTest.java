package com.vincnet.slidewindow;

import com.vincent.slidewindow.MinimumWindowSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSequenceTest {
    MinimumWindowSequence minimumWindowSequence = new MinimumWindowSequence();

    @Test
    void testCase1(){
        assertEquals("bfbd", minimumWindowSequence.minWindow("asbbfbdkfgebfbd", "bfd"));
    }
}
