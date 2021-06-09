package Maps_Sets_Tables;
/*
https://leetcode.com/problems/shuffle-string/
Given a string s and an integer array indices of the same length.

The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.
 */

public class ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }

        String word = new String(arr);

        return word;
    }

    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char a : arr) {
            stringBuilder.append(a);
        }

        return stringBuilder.toString();
    }

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
