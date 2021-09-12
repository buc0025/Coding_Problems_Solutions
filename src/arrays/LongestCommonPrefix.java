package arrays;
/*
https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {

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
