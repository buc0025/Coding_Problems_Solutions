package arrays;
/*
Mock interview question from Interpro Solutions 06/10/2021
Given an array of integers, remove all duplicates and return new array.
 */

public class RemoveDuplicates {

    // Initially thought of sorting given array and finding the duplicates that way but time complexity will no longer be o(n). I
    // sacrificed space for time in order to get a working solution.
    public int[] removeDuplicates(int[] input) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }

        int[] result = new int[set.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = set.get(i);
        }

        return result;
    }
}
