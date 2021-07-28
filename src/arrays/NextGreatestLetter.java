package arrays;
/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target/
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in
the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 */

public class NextGreatestLetter {

    // Binary search o(logn)
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int l = 0;
        int r = letters.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return letters[l];
    }

    // Linear solution o(n)
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }
}
