package com.vincent.graph;

/**
 * LeetCode 207 - Medium <br>
 * LeetCode 208 - Medium
 */
public class CourseSchedule {
    /**
     * LeetCode 207
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
                if (visited[i]) continue;
                if (inDegree[prerequisites[i][0]] == 0) {
                    inDegree[prerequisites[i][1]]--;
                    currentPreReqHandled++;
                    visited[i] = true;
                }
            }
            if (currentPreReqHandled == 0) return false; // if this handle cannot get rid all the prereq, which has cycle
            numOfPreReqHandled += currentPreReqHandled;
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = new int[][] {
                {1, 0},{2,0},{1,3}
        };
        System.out.println(cs.canFinish(4, prerequisites));
    }
}
