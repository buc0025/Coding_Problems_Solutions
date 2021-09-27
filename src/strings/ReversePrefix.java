package strings;
/*
https://leetcode.com/problems/reverse-prefix-of-word/
Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the
first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
The resulting string will be "dcbaefd".
Return the resulting string.
 */

public class ReversePrefix {

    //Incorrect solution. Thought problem was asking to swap first char of word with char at the first occurrence of ch
    public String reversePrefix(String word, char ch) {
        int index = -1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return word;
        }

        stringBuilder.append(ch);

        for (int i = 1; i < word.length(); i++) {
            if (i == index) {
                stringBuilder.append(word.charAt(0));
            } else {
                stringBuilder.append(word.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
