package strings;
/*
https://leetcode.com/problems/valid-palindrome/

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric
characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */

public class IsPalindrome {

    // 5/3/2022 solution
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll(" ", "");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isLetter(a) || Character.isDigit(a)) {
                stringBuilder.append(a);
            }
        }

        String word = stringBuilder.toString();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
