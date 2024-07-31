package com.vincent.twopointer;

/**
 * Write a function that takes a string, <i>s</i>, as an input and determines whether it is a palindrome. <br>
 * Constraint: <br>
 * - 1 &lt;  <i>s.length</i> &lt; 2 x 10^5 <br>
 * - LeetCode difficulty: Easy
 */
public class ValidPalindrome {
    //  The string <i>s<i> will not contain any white space and will only consist of ASCII characters(digits and letters).
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // LeetCode version, contains space and need to remove the extra space and also make upper to lower
    public boolean isPalindromeSpaceInclude(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // check alphanumeric
            char leftChar = s.charAt(left);
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }
            char rightChar = s.charAt(right);
            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }
            // change to the lower
            leftChar = toUpper(leftChar);
            rightChar = toUpper(rightChar);

            if (leftChar != rightChar) return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNumeric(Character c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private Character toUpper(Character c) {
        return (c >= 'A' && c <= 'Z') ? (char) ('a' + (c - 'A')) : c;
    }

}
