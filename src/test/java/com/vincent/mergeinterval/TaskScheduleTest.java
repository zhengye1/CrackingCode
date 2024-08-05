package com.vincent.mergeinterval;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskScheduleTest {
    static char[][] allTasks = {
            {'A', 'A', 'B', 'B'},
            {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
            {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
            {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
            {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

    static int[] allNs = {2, 1, 0, 3, 3};
    static int[] expected = {5,7,8,10,15};
    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            testCases.add(Arguments.of(allTasks[i], allNs[i], expected[i]));
        }
        return testCases.stream();
    }

    TaskScheduler taskScheduler = new TaskScheduler();

    @ParameterizedTest(name = "Test case: {index} => tasks={0}, n={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testTaskSchedulerUsingMapAndSort(char[] tasks, int n, int expected) {
        assertEquals(expected, taskScheduler.leastInterval(tasks, n));
    }

    @ParameterizedTest(name = "Test case: {index} => tasks={0}, n={1}, expected={2}")
    @MethodSource("generateTestCases")
    void testTaskSchedulerUsingArray(char[] tasks, int n, int expected) {
        assertEquals(expected, taskScheduler.leastIntervalLinearTime(tasks, n));
    }
}
