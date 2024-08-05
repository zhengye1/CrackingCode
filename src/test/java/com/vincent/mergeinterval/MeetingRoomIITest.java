package com.vincent.mergeinterval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingRoomIITest {
    static int[][][] inputs = {
            {{1, 2}, {3, 4}, {5, 6}, {7, 8}},
            {{0, 30}, {5, 10}, {15, 20}},
            {{7, 10}, {2, 4}},
            {{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}},
            {{1, 3}, {2, 6}, {8, 10}, {9, 15}, {12, 14}},
            {{1, 2}, {4, 6}, {3, 4}, {7, 8}},
            {{1, 7}, {2, 6}, {3, 7}, {4, 8}, {5, 8}},
            {{1, 2}, {2, 3}, {1, 2}}
    };

    static int[] expected = {1, 2, 1, 3, 2, 1, 5, 2};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(inputs[i], expected[i]));
        }
        return testCases.stream();
    }

    MeetingRoomII meetingRoomII = new MeetingRoomII();

    @ParameterizedTest(name = "Test case: {index} => intervals={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testMeetingRoomII(int[][] intervals, int expected) {
        assertEquals(expected, meetingRoomII.minMeetingRooms(intervals));
    }
}
