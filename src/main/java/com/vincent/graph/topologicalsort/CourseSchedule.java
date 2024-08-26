package com.vincent.graph.topologicalsort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 207 - Medium <br>
 * LeetCode 210 - Medium
 */
public class CourseSchedule {
    /**
     * LeetCode 207
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[] visited = new boolean[prerequisites.length];

        // find out how many course becomes preReq
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }
        int numOfPreReqHandled = 0;
        while (numOfPreReqHandled < prerequisites.length) {
            int currentPreReqHandled = 0;
            for (int i = 0; i < prerequisites.length; i++) {
                if (visited[i])
                    continue;
                if (inDegree[prerequisites[i][0]] == 0) {
                    inDegree[prerequisites[i][1]]--;
                    currentPreReqHandled++;
                    visited[i] = true;
                }
            }
            if (currentPreReqHandled == 0)
                return false; // if this handle cannot get rid all the prereq, which has cycle
            numOfPreReqHandled += currentPreReqHandled;
        }

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // how prereq need to finish for this course;
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        int index = 0;
        int[] result = new int[numCourses];

        // need a queue to enroll all the no preReq course
        Queue<Integer> enroll = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                enroll.offer(i);
        }

        while (!enroll.isEmpty()) {
            int currentCourse = enroll.poll();
            result[index++] = currentCourse;
            // just finish the current one, reduce the number that need this course
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == currentCourse){
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) enroll.offer(prerequisite[0]); // prereq[0] no more prereq, add to enroll test
                }
            }
        }

        return numCourses != index ? new int[0] : result;
    }

    public int[] findOrderQuick(int numCourses, int[][] prerequisites){
        int edgesLength = prerequisites.length;
        int[] to = new int[edgesLength];
        int[] head = new int[numCourses];
        Arrays.fill(head, -1);
        int[] next = new int[edgesLength];
        int[] inDegree = new int[numCourses];

        for (int i = 0 ; i < edgesLength ; i++){
            // b -> a
            int courseWantToLearn = prerequisites[i][0];
            int courseNeedToHave = prerequisites[i][1];
            to[i] = courseWantToLearn;
            next[i] = head[courseNeedToHave];
            head[courseNeedToHave] = i;
            inDegree[courseWantToLearn]++;
        }

        int[] q = new int[numCourses];
        int front = 0;
        int tail = 0;

        for (int i = 0 ; i < numCourses ; i++){
            if (inDegree[i] == 0){
                q[front++] = i;
            }
        }

        int[] result = new int[numCourses];
        int resultIndex = 0;
        while(front > tail){
            int currentCourse = q[tail++];
            result[resultIndex++] = currentCourse;
            for (int i = head[currentCourse] ; i != -1  ;  i = next[i]){
                int courseUnlock = to[i];
                inDegree[courseUnlock]--;
                if (inDegree[courseUnlock] == 0){
                    q[front++] = courseUnlock;
                }
            }
        }

        if (resultIndex == numCourses){
            return result;
        }
        return new int[0];
    }

}
