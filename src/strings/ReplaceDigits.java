package strings;
/*
https://leetcode.com/problems/replace-all-digits-with-characters/
You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.

There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.

For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).

Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
 */

public class ReplaceDigits {

    /*
    Top solution turns the given string into a char array. They use a for loop to only go over the odd indices and replaces them
    with the char value by adding the previous element and item that they're on. The char array is converted into a string to be
    returned.
     */
    public String replaceDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                stringBuilder.append(c);
            } else {
                int prev = s.charAt(i - 1);
                int num = Integer.valueOf(s.substring(i, i+1));
                int letter = prev + num;
                stringBuilder.append((char)letter);
            }
        }

        return stringBuilder.toString();
    }
}
