package strings;
/*
https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.
 */

public class DecryptStringAlphabet {

    public String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // Check if digit is more than 9
            if (i <= s.length() - 3 && s.charAt(i + 2) == '#') {
                int n = Integer.valueOf(s.substring(i, i + 2));
                char letter = (char) (n - 1 + 'a');
                stringBuilder.append(letter);
                i+=2;
            } else {
                int n = Integer.valueOf(s.substring(i, i + 1));
                char letter = (char) (n - 1 + 'a');
                stringBuilder.append(letter);
            }
        }

        return stringBuilder.toString();
    }
}
