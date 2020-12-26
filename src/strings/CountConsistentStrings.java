package strings;
/*
https://leetcode.com/problems/count-the-number-of-consistent-strings/
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all
characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.
 */

public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;

        for (String word : words) {
            for (int i = 0; i < allowed.length(); i++) {
                word = word.replaceAll(allowed.substring(i, i+1), "");
            }
            if (word.length() == 0) {
                count++;
            }
        }

        return count;
    }
}
