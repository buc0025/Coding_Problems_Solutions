package Maps_Sets_Tables;
/*
https://leetcode.com/problems/shuffle-string/
Given a string s and an integer array indices of the same length.

The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.
 */

public class ShuffleString {

    public String restoreString(String s, int[] indices) {

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(indices[i], s.substring(i, i + 1));
        }

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result += map.get(i);
        }

        return result;
    }
}
