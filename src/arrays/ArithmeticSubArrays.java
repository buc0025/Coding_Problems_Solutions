package arrays;
/*
https://leetcode.com/problems/arithmetic-subarrays/
A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two
consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all
valid i.
You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where
the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can
be rearranged to form an arithmetic sequence, and false otherwise.
 */

public class ArithmeticSubArrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();

        // Looping through l array and r array to check each subarray
        for (int i = 0; i < l.length; i++) {
            // Forming each subarray
            int[] arr = new int[r[i] - l[i] + 1];
            int index = 0;
            for (int j = l[i]; j <= r[i]; j++) {
                arr[index] = nums[j];
                index++;
            }

            Arrays.sort(arr);
            boolean order = true;

            // The subarray is in sequence in there are less than 3 elements to compare
            if (arr.length <= 2) {
                list.add(true);
            } else {
                // Checking to see if elements are in sequence in each subarray
                int sequence = Math.abs(arr[0] - arr[1]);
                for (int m = 0; m < arr.length-1; m++) {
                    if (Math.abs(arr[m] - arr[m + 1]) != sequence) {
                        list.add(false);
                        order = false;
                        break;
                    }
                }

                if (order) {
                    list.add(true);
                }
            }
        }

        return list;
    }
}
