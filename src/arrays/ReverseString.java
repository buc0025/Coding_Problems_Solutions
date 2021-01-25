package arrays;
/*
https://leetcode.com/problems/reverse-string/
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
 */

public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char swap = s[left];
            s[left] = s[right];
            s[right] = swap;
            left++;
            right--;
        }
    }
}
