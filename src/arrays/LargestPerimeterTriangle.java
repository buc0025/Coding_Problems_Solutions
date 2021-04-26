package arrays;
/*
https://leetcode.com/problems/largest-perimeter-triangle/
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
If it is impossible to form any triangle of a non-zero area, return 0.
 */

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i - 2 >= 0; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int base = 0;
        int sides = 0;

        for (int i = nums.length - 1; i - 2 >= 0; i--) {
            base = nums[i];
            sides = nums[i - 1] + nums[i - 2];

            if (sides > base) {
                break;
            }
        }

        if (sides > base) {
            return sides + base;
        } else {
            return 0;
        }
    }
}
