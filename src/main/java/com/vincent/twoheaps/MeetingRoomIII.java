package com.vincent.twoheaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 2402 - Hard
 * Given a list of meeting and number of rooms available, return the meeting room number that holds most meeting
 */
public class MeetingRoomIII {
    public int mostBooked(int[][] meetings, int rooms) {
        int[] counter = new int[rooms]; // counter to count meeting
        Queue<Integer> available = new PriorityQueue<>();
        // useRoom store [finishedTime, roomNumber]
        // used room to record the early finish, if they finished the same time, then small room number come out first
        Queue<int[]> usedRoom = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < rooms; i++) {
            available.offer(i);
        }

        // Sort it with start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            while (!usedRoom.isEmpty() && usedRoom.peek()[0] <= startTime) {
                int room = usedRoom.poll()[1];
                available.offer(room);
            }

            if (available.isEmpty()) {
                int end = usedRoom.peek()[0];
                int room = usedRoom.poll()[1];
                endTime = end + (endTime - startTime);
                available.offer(room);
            }
            int room = available.poll();
            usedRoom.offer(new int[]{endTime, room});
            counter[room]++;
        }

        int maxMeetingsRoom = 0;
        for (int i = 1; i < rooms; i++){
            if (counter[i] > counter[maxMeetingsRoom]){
                maxMeetingsRoom = i;
            }
        }
        return maxMeetingsRoom;
    }
}
