package strings;
/*
https://leetcode.com/problems/maximum-score-after-splitting-a-string/
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left
substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 */

public class MaxScoreAfterSplit {

    public int maxScore(String s) {
        int max = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            String left = s.substring(0, i + 1);
            String right = s.substring(i + 1);
            int zeros = 0;
            int ones = 0;

            for (int j = 0; j < left.length(); j++) {
                if (left.charAt(j) == '0') {
                    zeros++;
                }
            }

            for (int k = 0; k < right.length(); k++) {
                if (right.charAt(k) == '1') {
                    ones++;
                }
            }

            max = Math.max(zeros + ones, max);
        }

        return max;
    }
}
