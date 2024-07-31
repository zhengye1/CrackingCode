package com.vincent.twopointer;

import javax.xml.stream.events.Characters;

/**
 * LeetCode question 151 Medium <br>
 * Given a <i>sentence</i>
 * reverse the order of the word in the sentence and remove trilling space and only 1 space between the word
 * O(1) extra space
 */
public class ReverseWordInSentence {
    public String reverseWords(String sentence){
        // clean up extra space
        sentence = sentence.replaceAll("\\s+", " ").trim();

        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;

        // make the life easy, reverse the whole sentence first
        strRev(charArray, 0, strLen);

        // now find the word and just reverse the word
        for (int start = 0, end = 0; end <= strLen; end++){
            if (end == strLen || charArray[end] == ' '){
                // reverse the world
                int endIdx = (end == strLen)? end : end - 1;
                strRev(charArray, start, endIdx);
                start = end + 1; // move to next world
            }
        }
        return new String(charArray);

    }

    private void strRev(char[] charArray, int index, int length){
        while (index < length){
            char temp = charArray[index];
            charArray[index] = charArray[length];
            charArray[length] = temp;
            index++;
            length--;
        }
    }
}
