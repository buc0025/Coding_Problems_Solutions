package strings;
/*
https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.
 */

public class StringArrEquals {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        for (String word : word1) {
            string1.append(word);
        }

        for (String word : word2) {
            string2.append(word);
        }

        return string1.toString().equals(string2.toString());
    }
}
