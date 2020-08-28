package arrays;
/*
https://leetcode.com/problems/shuffle-the-array/
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */

public class Shuffle {

    public int[] shuffle(int[] nums, int n) {

        int[] arr = new int[nums.length];
        int first = 0;
        int second = n;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = nums[first]; first++;
            } else {
                arr[i] = nums[second]; second++;
            }
        }

        return arr;
    }
}
