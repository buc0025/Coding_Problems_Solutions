package strings;
/*
https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.

The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
 */

public class GenerateTheString {

    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stringBuilder.append('a');
        }

        if (n % 2 == 0) {
            stringBuilder.deleteCharAt(n - 1);
            stringBuilder.append('b');
        }

        return stringBuilder.toString();
    }
}
