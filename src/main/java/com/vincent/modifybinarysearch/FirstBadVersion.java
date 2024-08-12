package com.vincent.modifybinarysearch;

/**
 * LeetCode 278 - Easy
 * Given an integer <i>n</i> and an api call <i>isBadVersion(version)</i> which return does the version is bad or not
 * Find the first bad version number and the number of calls
 */
public class FirstBadVersion {
    int version;

    public int[] firstBadVersion(int n) {
        int[] result = new int[2];
        int left = 1, right = n;
        int appCount = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                result[0] = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            appCount++;
        }
        result[1] = appCount;
        return result;
    }

    public int[] firstBadVersionRecursive(int n) {
        int[] result = new int[2];
        return firstBadVersionRecursiveHelper(1, n, result);
    }

    private int[] firstBadVersionRecursiveHelper(int start, int end, int[] result) {

        if (start > end)
            return result;
        result[1]++;
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            result[0] = mid;
            return firstBadVersionRecursiveHelper(start, mid - 1, result);
        } else {
            return firstBadVersionRecursiveHelper(mid + 1, end, result);
        }
    }

    private boolean isBadVersion(int s) {
        return s >= this.version;
    }

    public void setBadVersion(int version) {
        this.version = version;
    }

}
