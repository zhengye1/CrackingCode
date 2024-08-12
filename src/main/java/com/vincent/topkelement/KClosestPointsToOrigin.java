package com.vincent.topkelement;

import com.vincent.util.Point;

import java.util.*;

/**
 * LeetCode 973 - Medium
 * LeetCode version using 2d array to represent x and y and return int[][]
 */
public class KClosestPointsToOrigin {
    public List<Point> kClosest(Point[] points, int k) {
        // [Point, distance]
        Queue<Object[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> -(double)a[1]));
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < Math.min(points.length, k); i++) {
            maxHeap.offer(new Object[] {points[i], points[i].euclideanDistanceToOrigin()});
        }

        int nextIndex = maxHeap.size(); // in case we still have point in the array
        while (!maxHeap.isEmpty() && nextIndex < points.length) {
            double distance = points[nextIndex].euclideanDistanceToOrigin();
            if (distance < (double)maxHeap.peek()[1]){
                maxHeap.poll();
                maxHeap.offer(new Object[] {points[nextIndex], distance});
            }
            nextIndex++;
        }
        // now the heap should contain k element
        while (!maxHeap.isEmpty()) {
            result.add(((Point)maxHeap.poll()[0]));
        }
        return result;
    }


    public int[][] kClosest(int[][] points, int k) {
        Queue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> -a[2]));
        int[][] result = new int[k][2];
        int resultIndex = 0;

        // add the thing in
        for (int i = 0; i < Math.min(points.length, k); i++){
            int x = points[i][0];
            int y = points[i][1];
            maxHeap.offer(new double[]{((double)x), ((double)y) ,euclideanDistanceToOrigin(x, y)});
        }
        int nextIndex = maxHeap.size();
        while (!maxHeap.isEmpty() && nextIndex < points.length){
            int x = points[nextIndex][0];
            int y = points[nextIndex][1];
            double distance = euclideanDistanceToOrigin(x, y);
            if (distance < maxHeap.peek()[2]){
                maxHeap.poll();
                maxHeap.offer(new double[]{(double)x, (double)y, distance});
            }
            nextIndex++;
        }

        while (!maxHeap.isEmpty()){
            double[] point = maxHeap.poll();
            result[resultIndex] = new int[]{(int)point[0], (int)point[1]};
            resultIndex++;
        }
        return result;
    }
    public double euclideanDistanceToOrigin(int x, int y){
        return Math.sqrt(x * x + y * y);
    }

}
