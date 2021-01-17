package strings;
/*
https://leetcode.com/problems/decoded-string-at-index/
An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time
and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 */

public class DecodeAtIndex {
    //Incorrect attempt. Memory limit exceeded
    public String decodeAtIndex(String string, int K) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if ((int)string.charAt(i) >= 48 && (int)string.charAt(i) <= 57) {
                String newString = stringBuilder.toString();
                String inside = string.substring(i, i+1);
                int num = Integer.valueOf(inside);
                for (int j = 1; j < num; j++) {
                    stringBuilder.append(newString);
                }
            } else {
                stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString().substring(K - 1, K);
    }
}
