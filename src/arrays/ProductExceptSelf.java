package arrays;
/*
https://leetcode.com/problems/product-of-array-except-self/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int product = 1; // Get the product of all the elements in array

        Set<Integer> set = new HashSet<>(); // Keeps track of how many zeros are in array

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                set.add(i);
            } else {
                product *= nums[i];
            }
        }

        // If there's only 1 zero in the array then all elements should be 0 except for the element that's already 0
        if (set.size() == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (nums[i] == 0) {
                    arr[i] = product;
                }
            }
            return arr;
        }

        // The product of every element will be 0 if there are more than 1 zero in the array
        if (set.size() > 1) {
            return arr;
        }

        // If there are no zeros, the arr[i] will be the product of all elements except itself
        for (int i = 0; i < arr.length; i++) {
            arr[i] = product / nums[i];
        }

        return arr;
    }
}
