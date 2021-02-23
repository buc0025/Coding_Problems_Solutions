package arrays;
/*
https://leetcode.com/problems/shortest-distance-to-a-character/
Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and
answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 */

public class ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();

        // List keeps track of the indexes of char c
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }

        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++) {
            int min = s.length(); // The greatest possible length would
            // be the first char to the last char in the string
            for (int j = 0; j < list.size(); j++) {
                min = Math.min(Math.abs(i - list.get(j)), min);
                // Comparing the index of s to the indexes of c to find
                // the shortest distance
            }
            arr[i] = min;
        }

        return arr;
    }
}
