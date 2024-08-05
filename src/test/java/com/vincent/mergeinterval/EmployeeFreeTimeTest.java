package com.vincent.mergeinterval;

import com.vincent.util.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFreeTimeTest {
    static List<List<List<Interval>>> inputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                    Arrays.asList(new Interval(1, 3)),
                    Arrays.asList(new Interval(4, 10))),
            Arrays.asList(
                    Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                    Arrays.asList(new Interval(2, 4)),
                    Arrays.asList(new Interval(2, 5), new Interval(9, 12))),
            Arrays.asList(
                    Arrays.asList(new Interval(2, 3), new Interval(7, 9)),
                    Arrays.asList(new Interval(1, 4), new Interval(6, 7))),
            Arrays.asList(
                    Arrays.asList(new Interval(3, 5), new Interval(8, 10)),
                    Arrays.asList(new Interval(4, 6), new Interval(9, 12)),
                    Arrays.asList(new Interval(5, 6), new Interval(8, 10))),
            Arrays.asList(
                    Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11)),
                    Arrays.asList(new Interval(3, 4), new Interval(7, 12)),
                    Arrays.asList(new Interval(1, 3), new Interval(7, 10)),
                    Arrays.asList(new Interval(1, 4)),
                    Arrays.asList(new Interval(7, 10), new Interval(11, 12))),
            Arrays.asList(
                    Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8)),
                    Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 8))), Arrays.asList(
                    Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8),
                            new Interval(9, 10), new Interval(11, 12)),
                    Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8),
                            new Interval(9, 10), new Interval(11, 12)),
                    Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8),
                            new Interval(9, 10), new Interval(11, 12)),
                    Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8),
                            new Interval(9, 10), new Interval(11, 12))));

    static List<List<Interval>> expected = Arrays.asList(
            Arrays.asList(new Interval(3, 4)),
            Arrays.asList(new Interval(5, 6), new Interval(7, 9)),
            Arrays.asList(new Interval(4, 6)),
            Arrays.asList(new Interval(6, 8)),
            Arrays.asList(new Interval(4, 6)),
            Arrays.asList(),
            Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 7), new Interval(8, 9), new Interval(10, 11))
    );

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.size(); i++) {
            testCases.add(Arguments.of(inputs.get(i), expected.get(i)));
        }
        return testCases.stream();
    }

    EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();

    @ParameterizedTest(name = "Test case: {index} => schedule={0}, expected={1}")
    @MethodSource("generateTestCases")
    void testEmployeeFreeTime(List<List<Interval>> schedule, List<Interval> expected) {
        assertEquals(expected, employeeFreeTime.employeeFreeTime(schedule));
    }


}
