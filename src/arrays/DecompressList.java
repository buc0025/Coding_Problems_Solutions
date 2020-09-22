package arrays;
/*
https://leetcode.com/problems/decompress-run-length-encoded-list/
We are given a list nums of integers representing a list compressed with run-length encoding.
Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair,
There are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to
generate the decompressed list. Return the decompressed list.
*/

public class DecompressList {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;

        for (int i = 0; i < nums.length; i+=2) { //adds every other element to determine size of new array
            size += nums[i];
        }

        int[] arr = new int[size];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {   //using the frequency to determine how many times to concatenate
                while (nums[i] > 0) {   //looping through the number of times a value should appear in array
                    arr[index] = nums[i + 1];   //assigning the value to new array
                    index++;
                    nums[i]--;
                }
            }
        }
        return arr;
    }
}
