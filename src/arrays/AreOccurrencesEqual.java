package arrays;
/*
https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
 */

public class AreOccurrencesEqual {

    public boolean areOccurrencesEqual(String s) {
        int[] alphabet = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 97]++;
        }

        for (int a : alphabet) {
            if (a != 0) {
                count = a;
                break;
            }
        }

        for (int a : alphabet) {
            if (a != 0 && a != count) {
                return false;
            }
        }

        return true;
    }
}
