package com.vincent.slowfast;

/**
 * LeetCode 202 Easy
 * Give an integer <i>n</i>, replace the number with the sum of the square of each digit<br>
 * Repeat the process until: <br>
 * - the number is equal to 1, which means it is happy number <br>
 * - the number is in the cycle, which is not a happy number <br>
 * Constraint: <br>
 * - 1 &lt;= <i>n</i> &lt;= 2^31-1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        while (slow != fast && fast != 1) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
        return fast == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += (int) Math.pow(digit, 2);
        }
        return sum;
    }
}
