package com.vincent.slowfast;

/**
 * LeetCode 457 - Medium <br>
 * Given a non-zero integers array <i>nums</i>,
 * which represent the step need to move forward or backward from current index.
 * When reaching either end of the array, traversal around to the opposite end <br>
 * A Cycle was detected if: <br>
 * - the sequence on the same direction <br>
 * - the length of the sequence is at least 2 <br>
 * - the sequence starts and ends on the same index <br>
 * Constraints: <br>
 * - 1 &lt;= <i>nums.length</i> &lt;= 10^3 <br>
 * - 5000 &lt;= <i>nums[i]</i> &lt;= 5000 <br>
 * <i>nums[i]</i> != 0
 */
public class CircularArrayLoop {
    // 1->3-2->1->4

    public boolean circularArrayLoop(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;
            while (true) {
                slow = nextStep(slow, nums[slow], size); // slow pointer moves one step
                if (isNotCycle(nums, forward, slow)) // detect is it self-loop on this point
                    break;

                fast = nextStep(fast, nums[fast], size); // fast pointer moves two steps
                if (isNotCycle(nums, forward, fast))
                    break;

                fast = nextStep(fast, nums[fast], size); // fast pointer moves two steps
                if (isNotCycle(nums, forward, fast))
                    break;

                if (slow == fast)
                    return true;
            }
        }
        return false;
    }

    private int nextStep(int currentIndex, int step, int arraySize) {
        int result = (currentIndex + step) % arraySize;
        if (result < 0)
            result += arraySize;
        return result;
    }

    private boolean isNotCycle(int[] nums, boolean prevDirection, int currentIndex) {
        boolean currentDirection = nums[currentIndex] > 0;
        // nums[currentIndex] % nums.length means the sequence it just self-loop with 1 node
        // which is not a cycle
        return prevDirection != currentDirection || Math.abs(nums[currentIndex] % nums.length) == 0;
    }
}
