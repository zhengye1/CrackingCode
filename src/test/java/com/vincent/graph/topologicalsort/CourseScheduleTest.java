package com.vincent.graph.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleTest {
   static int[] numOfCourses = {4, 5, 2, 7, 3, 2, 10, 5, 5};
    static int[][][]prerequisites = {
        {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
        {{1, 0}, {2, 0}, {3, 1},{4, 3}},
        {{1, 0}},
        {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}},
        {{1, 0}, {2, 1}},
        {{1, 0}, {0, 1}},
        {{1, 0}, {2, 1}, {3, 2}, {4, 3}},
        {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {0, 4}},
        {{2, 0}, {2, 1}, {3, 2}, {4, 2}, {3, 1}}
    };
    static boolean[] expected = {true, true, true, true, true, false, true, false, true};

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            testCases.add(Arguments.of(prerequisites[i], numOfCourses[i], expected[i]));
        }
        return testCases.stream();
    }

    CourseSchedule courseSchedule = new CourseSchedule();


    @ParameterizedTest(name = "Test case: {index} => prerequisites={0} numOfCourse={1} expected={2}")
    @MethodSource("generateTestCases")
    void courseScheduleTestI(int[][] prerequisites, int numOfCourses, boolean expected) {
        assertEquals(expected, courseSchedule.canFinish(numOfCourses, prerequisites));
    }

    @ParameterizedTest(name = "Test case: {index} => prerequisites={0} numOfCourse={1} expected={2}")
    @MethodSource("generateTestCases")
    void courseScheduleTestII(int[][] prerequisites, int numOfCourses, boolean expected) {
        int[] actual = courseSchedule.findOrder(numOfCourses, prerequisites);
        // check possible first
        boolean canFinish = courseSchedule.canFinish(numOfCourses, prerequisites);
        if (canFinish)
            assertTrue(isValidTopologicalSort(actual, prerequisites, numOfCourses));
        else
            assertEquals(0, actual.length);
    }

    @ParameterizedTest(name = "Test case: {index} => prerequisites={0} numOfCourse={1} expected={2}")
    @MethodSource("generateTestCases")
    void courseScheduleTestQuickII(int[][] prerequisites, int numOfCourses, boolean expected) {
        int[] actual = courseSchedule.findOrderQuick(numOfCourses, prerequisites);
        // check possible first
        boolean canFinish = courseSchedule.canFinish(numOfCourses, prerequisites);
        if (canFinish)
            assertTrue(isValidTopologicalSort(actual, prerequisites, numOfCourses));
        else
            assertEquals(0, actual.length);
    }

    private boolean isValidTopologicalSort(int[] actual, int[][] prerequisites, int numOfCourses) {
        // check the size
        if (actual.length != numOfCourses) return false;

        // check each one in the index
        int[] indexInResult = new int[numOfCourses];
        for (int i = 0; i < numOfCourses; i++) {
            indexInResult[actual[i]] = i;
        }

        // check it have correct prereq
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            if (indexInResult[pre] > indexInResult[course]) return false;
        }
        return true;
    }
}
