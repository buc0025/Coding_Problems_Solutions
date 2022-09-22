package arrays;
/*
https://leetcode.com/problems/sort-array-by-parity/

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
 */

public class SortByParity {

    // 9/16/2022 solution
    public int[] sortArrayByParity(int[] nums) {
        int left = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                while (i < left) {
                    if (nums[left] % 2 == 0) {
                        int odd = nums[i];
                        nums[i] = nums[left];
                        nums[left] = odd;
                        left--;
                        break;
                    }
                    left--;
                }
            }
        }

        return nums;
    }

    // 9/16/2022 solution
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < even.size()) {
                nums[i] = even.get(i);
            } else {
                nums[i] = odd.get(i - even.size());
            }
        }

        return nums;
    }
}
