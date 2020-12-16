package arrays;
/*
https://leetcode.com/problems/partition-labels/
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each
letter appears in at most one part, and return a list of integers representing the size of these parts.
 */

public class PartitionLabels {

    // Was unable to solve on my own. Had to look at solutions and videos to understand the code.
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int[] lastIndices = new int[26];

        // The alphabet array contains the last index of each letter
        for (int i = 0; i < S.length(); i++) {
            lastIndices[S.charAt(i) - 'a'] = i;
        }

        int end = 0;
        int front = 0;

        for (int i = 0; i < S.length(); i++) {
            // Looking for the last index of that element in the partition
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - front + 1);
                front = end + 1;
            }
        }

        return list;
    }
}
