package com.vincent.twoheaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianOfStreamTest {

    @Test
    void testStream(){
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.insertNum(35);
        assertEquals(35.0, medianOfStream.findMedian());
        medianOfStream.insertNum(22);
        assertEquals(28.5, medianOfStream.findMedian());
        medianOfStream.insertNum(30);
        assertEquals(30.0, medianOfStream.findMedian());
        medianOfStream.insertNum(25);
        assertEquals(27.5, medianOfStream.findMedian());
        medianOfStream.insertNum(1);
        assertEquals(25.0, medianOfStream.findMedian());
    }
}
