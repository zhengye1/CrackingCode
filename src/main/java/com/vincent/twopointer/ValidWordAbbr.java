package com.vincent.twopointer;

/** LeetCode question # 408 - Easy
 * Given a string <i>word</i> and an abbreviation <i>abbr</i>,
 * return <i>TRUE</i> if the abbreviation matches the given string. Otherwise, return <i>FALSE</i>. <br>
 * Constraint: <br>
 * - 1 &lt;= <i>word.length</i> &lt;= 20 <br>
 * - <i>word</i> only contains lowercase character <br>
 * - 1 &lt;= <i>abbr.length</i> &lt;= 10 <br>
 * - <i>abbr</i> contains letter and digit <br>
 * - <i>abbr</i> contain 32-bit integer
 */
public class ValidWordAbbr {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        int abbrIndex = 0;
        while (abbrIndex < abbr.length()){
            // check digit first
            if (Character.isDigit(abbr.charAt(abbrIndex))){
                if (abbr.charAt(abbrIndex) == '0') return false;
                int num = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))){
                    num = num * 10 + abbr.charAt(abbrIndex) - '0';
                    abbrIndex++;
                }
                wordIndex += num;
            }else{
                if (wordIndex >= word.length() || word.charAt(wordIndex) != abbr.charAt(abbrIndex)) return false;
            }
            wordIndex++;
            abbrIndex++;
        }
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}
