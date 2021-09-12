package arrays;
/*
https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {

    /*
    Originally thought of using a set to keep track of common prefixes when looping through array. The size of the set will be the
    same as the index of the string they have in common but issue will arise if there are repeating chars in a string such as
    {"sstring", "ssbing"}.
    The longest common prefix can't be longer than any word in the array. This is why I used the length of the first word for the
    while loop. If the char at index is not the same as the previous then the loop breaks and returns the length of longest
    common prefix.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int maxLen = strs[0].length();
        int index = 0;
        int count = 0;
        boolean different = false;

        while (maxLen > 0) {
            for (int i = 1; i < strs.length; i++) {
                // The length of the word can't be shorter than the index we're comparing
                if (strs[i].length() - 1 < index || strs[i -1].charAt(index) != strs[i].charAt(index)) {
                    different = true;
                    break;
                }
            }

            if (different) {
                break;
            }

            index++;
            maxLen--;
            count++;
        }

        return strs[0].substring(0, count);
    }
}
