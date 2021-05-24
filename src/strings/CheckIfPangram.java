package strings;
/*
https://leetcode.com/problems/check-if-the-sentence-is-pangram/
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */

public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            arr[sentence.charAt(i) - 'a']++;
        }

        for (int a : arr) {
            if (a == 0) {
                return false;
            }
        }

        return true;
    }
}
