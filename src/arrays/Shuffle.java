package arrays;
/*
https://leetcode.com/problems/shuffle-the-array/
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */

public class Shuffle {

    // 5/19/2022 solution
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            arr[index++] = nums[i];
            arr[index++] = nums[n + i];
        }

        return arr;
    }

    public int[] shuffle(int[] nums, int n) {

        int[] arr = new int[nums.length];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = nums[i/2];
            } else {
                arr[i] = nums[n]; n++;
            }
        }

        return arr;
    }
}
