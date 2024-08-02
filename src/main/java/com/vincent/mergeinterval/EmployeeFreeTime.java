package com.vincent.mergeinterval;

import com.vincent.util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 759 Hard
 * Given a list of non-overlapping intervals in sorted order for each employee.
 * Find the free time between employees.
 * Constraint:
 * 1. schedule length is 50
 * 2. Interval start and end between [0, 10^8]
 */
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> employeeSchedule = schedule.get(i);
            Interval interval = employeeSchedule.getFirst();
            heap.offer(new int[] {interval.start, i, 0});
        }
        int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).start;
        while (!heap.isEmpty()) {
            int[] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];

            Interval interval = schedule.get(i).get(j);

            if (interval.start > previous) {
                result.add(new Interval(previous, interval.start));
            }

            previous = Math.max(previous, interval.end);

            if (j + 1 < schedule.get(i).size()) {
                Interval nextInterval = schedule.get(i).get(j + 1);
                heap.offer(new int[] {nextInterval.start, i, j + 1});
            }
        }
        return result;
    }
}
