package Maps_Sets_Tables;
/*
https://leetcode.com/problems/partition-labels/
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so
that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 */

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int max = 0; // keeps track of length of first and last index of a char
        int[] arr = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {
            // Finding the length a partition
            if (S.lastIndexOf(S.charAt(i))- S.indexOf(S.charAt(i)) >= max) {
                max += S.lastIndexOf(S.charAt(i)) +1;
                list.add(max);
            }
            // if char is no longer a partition then max counter resets
            if (S.lastIndexOf(S.charAt(i)) > max ) {
                max = 0;
            }
            // assigning length of partitions to array
            arr[i] = max;
        }
        // Assigns each element in array to map along with number of occurrences
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i == 0) {
                map.put(arr[i], 1);
            }
            else if (arr[i] == 0) {
                map.put(arr[i+1], 1);
            }
            else if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            } else {
                map.put(arr[i], 1);
            }
        }
        // New list that returns size of partitions
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(map.get(list.get(i)));
        }
        return result;
    }
}
