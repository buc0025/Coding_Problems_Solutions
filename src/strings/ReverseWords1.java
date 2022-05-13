package strings;
/*
https://leetcode.com/problems/reverse-words-in-a-string/

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a
single space separating the words. Do not include any extra spaces.
 */

public class ReverseWords1 {

    // 5/13/2022 solution
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                builder.append(arr[i]);
                builder.append(" ");
            }
        }

        return builder.toString().trim();
    }
}
