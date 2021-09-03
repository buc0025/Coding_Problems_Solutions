package strings;
/*
https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
There is a special typewriter with lowercase English letters 'a' to 'z' arranged in a circle with a pointer. A character can only
be typed if the pointer is pointing to that character. The pointer is initially pointing to the character 'a'.

Each second, you may perform one of the following operations:

Move the pointer one character counterclockwise or clockwise.
Type the character the pointer is currently on.
Given a string word, return the minimum number of seconds to type out the characters in word.
 */

public class MinTimeToType {

    public int minTimeToType(String word) {
        int count = word.length(); // seconds count when it's on the letter
        int start = 0; // starting position is 'a'

        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 97;
            int diff = Math.abs(start - pos);

            // There are 26 letters in the alphabet, if the difference is greater than 13 then we can go counterclockwise
            if (diff > 13) {
                diff = 26 - diff;
            }

            count += diff;
            start = pos;
        }

        return count;
    }
}
