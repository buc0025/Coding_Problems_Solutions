package Stacks;
/*
https://leetcode.com/problems/create-target-array-in-the-given-order/
Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.
 */

public class TargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            stack.add(index[i], nums[i]);   //Using a stack to set values in proper indices
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = stack.pop();  //reassigning elements to original array starting from the back with items popped off of stack
        }
        return nums;
    }
}
