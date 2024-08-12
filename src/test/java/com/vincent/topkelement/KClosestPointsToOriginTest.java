package com.vincent.topkelement;

import com.vincent.util.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class KClosestPointsToOriginTest {
    static Point[] pointsOne = new Point[]{
            new Point(1, 3), new Point(3, 4), new Point(2, -1)
    };
    static Point[] pointsTwo = new Point[]{
            new Point(1, 3), new Point(2, 4), new Point(2, -1), new Point(-2, 2), new Point(5, 3), new Point(3, -2)
    };
    static Point[] pointsThree = new Point[]{
            new Point(1, 3), new Point(5, 3), new Point(3, -2), new Point(-2, 2)
    };
    static Point[] pointsFour = new Point[]{
            new Point(2, -1), new Point(-2, 2), new Point(1, 3), new Point(2, 4)
    };
    static Point[] pointsFive = new Point[]{
            new Point(1, 3), new Point(2, 4), new Point(2, -1), new Point(-2, 2), new Point(5, 3), new Point(3, -2), new Point(5, 3), new Point(3, -2)
    };
    static Point[][] points = {pointsOne, pointsTwo, pointsThree, pointsFour, pointsFive};
    static int[] kList = {2, 3, 1, 4, 5};

    static Point[][] expected = {
            new Point[]{new Point(1, 3), new Point(2, -1)},
            new Point[]{new Point(1, 3), new Point(2, -1), new Point(-2, 2)},
            new Point[]{new Point(-2, 2)},
            new Point[]{new Point(2, 4), new Point(1, 3), new Point(-2, 2), new Point(2, -1)},
            new Point[]{new Point(3, -2), new Point(3, -2), new Point(2, -1), new Point(-2, 2), new Point(1, 3)}
    };

    static Stream<Arguments> generateTestCases() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            List<Point> resultList = new ArrayList<>(Arrays.asList(expected[i]));
            testCases.add(Arguments.of(points[i], kList[i], resultList));
        }
        return testCases.stream();
    }

    KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();

    @ParameterizedTest(name = "Test case: {index} => points={0}, k={1} expect={2}")
    @MethodSource("generateTestCases")
    void KClosestPointsToOriginTest(Point[] point, int k,  List<Point>expected) {
        // since it can return in any order, so we need to sort them first by distance...
        expected.sort((o1, o2) -> {
            int distance = (int) (o1.euclideanDistanceToOrigin()-o2.euclideanDistanceToOrigin());
            if (distance == 0) {
                return o1.getX() - o2.getX();
            }
            return distance;
        });
        List<Point> actual = kClosestPointsToOrigin.kClosest(point, k);
        actual.sort((o1, o2) -> {
            int distance = (int) (o1.euclideanDistanceToOrigin()-o2.euclideanDistanceToOrigin());
            if (distance == 0) {
                return o1.getX() - o2.getX();
            }
            return distance;
        });
        assertIterableEquals(expected, actual);
    }

    static Stream<Arguments> generateTestCases2() {
        List<Arguments> testCases = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            int[][] expectedArray = new int[expected[i].length][2];
            for (int j = 0; j < expectedArray.length; j++) {
                expectedArray[j][0] = expected[i][j].getX();
                expectedArray[j][1] = expected[i][j].getY();
            }
            int[][] pointInput = new int[points[i].length][2];
            for (int j = 0; j < pointInput.length; j++) {
                pointInput[j][0] = points[i][j].getX();
                pointInput[j][1] = points[i][j].getY();
            }


            testCases.add(Arguments.of(pointInput, kList[i], expectedArray));

        }
        return testCases.stream();
    }

    @ParameterizedTest(name = "Test case: {index} => points={0}, k={1} expect={2}")
    @MethodSource("generateTestCases2")
    void testKClosestPointToOriginTest(int[][]points, int k, int[][] expected) {
        Arrays.sort(expected, ((o1, o2) -> {
            int distance = (int) (kClosestPointsToOrigin.euclideanDistanceToOrigin(o1[0], o1[1])
                    - kClosestPointsToOrigin.euclideanDistanceToOrigin(o2[0], o2[1]));
            if (distance == 0) {
                return o1[0] - o2[0];
            }
            return distance;
        }));

        int[][] actual = kClosestPointsToOrigin.kClosest(points, k);
        Arrays.sort(actual, ((o1, o2) -> {
            int distance = (int) (kClosestPointsToOrigin.euclideanDistanceToOrigin(o1[0], o1[1])
                    - kClosestPointsToOrigin.euclideanDistanceToOrigin(o2[0], o2[1]));
            if (distance == 0) {
                return o1[0] - o2[0];
            }
            return distance;
        }));

        assertArrayEquals(expected, actual);
    }
}
