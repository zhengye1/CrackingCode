package com.vincent.twoheaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingRoomIIITest {
    static int[][][] input = {
            {{0, 10}, {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}},
            {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}},
            {{1, 2}, {0, 10}, {2, 3}, {3, 4}},
            {{0, 2}, {1, 2}, {3, 4}, {2, 4}},
            {{1, 9}, {2, 8}, {3, 7}, {4, 6}, {5, 11}}
    };

    static int[] rooms = {3, 3, 2, 4, 3};
    static int[] expected = {0, 1, 1, 0, 1};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(input[i], rooms[i], expected[i]));
        }
        return testCases.stream();
    }
    MeetingRoomIII meetingRoomIII = new MeetingRoomIII();

    @ParameterizedTest(name = "Test case: {index} => meetings={0}, room={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testMeetingRoomIII(int[][] meetings ,int room, int expected) {
        assertEquals(expected, meetingRoomIII.mostBooked(meetings, room));
    }
}
