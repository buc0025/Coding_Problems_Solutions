package arrays;
/*
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions
(including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is
the modulo operation.
 */

public class CheckArraySortedRotated {

    // Shortened o(n) solutiong
    public boolean check(int[] nums) {
        int sorted = 0;
        if (nums[0] < nums[nums.length - 1]) {
            sorted++;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted++;
            }
            if (sorted > 1) {
                return false;
            }
        }

        return true;
    }

    /*
    Improved time and space complexity by not using a list to track sorted array. Logic is checking the start of the smallest
    number until the end of the array to see if numbers are in order and also coming it to supposed biggest number. Same idea
    for beginning of array to index of where biggest number in array is.
     */
    public boolean check(int[] nums) {
        int notSorted = 0;
        int smallIndex = 0;
        int bigIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                notSorted++;
                smallIndex = i;
                bigIndex = i - 1;
            }
        }

        if (notSorted > 1) {
            return false;
        }

        if (notSorted == 0) {
            return true;
        }

        int endNum = nums[nums.length - 1];

        for (int i = smallIndex + 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] || nums[i - 1] > nums[bigIndex] || nums[i] > nums[bigIndex]) {
                return false;
            }
        }

        for (int i = 1; i <= bigIndex; i++) {
            if (nums[i] < nums[i - 1] || nums[i - 1] < endNum || nums[i] < endNum) {
                return false;
            }
        }

        return true;
    }

    /*
    If numbers in the array are not in sorted order then those should be the biggest and smallest numbers in the array. If there
    are more than two instances where numbers in array are not in order then there is no way for array to be sorted even after
    rotation. Once I found the break in the array, I started adding the remaining numbers into a list. I then started adding
    numbers from the beginning array to the list until I right before the break in the array. If the array is sorted and rotated,
    the list should be in sorted order.
     */
    public boolean check(int[] nums) {
        int notSorted = 0;
        int smallIndex = 0;
        int bigIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                notSorted++;
                smallIndex = i;
                bigIndex = i - 1;
            }
        }

        if (notSorted > 1) {
            return false;
        }

        if (notSorted == 0) {
            return true;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = smallIndex; i < nums.length; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i <= bigIndex; i++) {
            list.add(nums[i]);
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    /*
    Idea was to find the smallest element in the array and its index, from that index I will extract each element in order until
    all elements inside array has been extracted and placed into a list. The list is compared with a sorted array. If they match
    then it will return true. Unfortunately this only passed 102/105 test cases and didn't pass for arrays such as [6,10,6] where
    duplicates aren't side by side
     */
    public boolean check(int[] nums) {
        int len = nums.length;
        boolean check = true;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = arr[0];
        List<Integer> list = new ArrayList<>();

        int startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                startIndex = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (startIndex >= len) {
                startIndex = 0;
            }
            list.add(nums[startIndex]);
            startIndex++;

            if (list.get(i) != arr[i]) {
                check = false;
            }
        }

        return check;
    }
}
