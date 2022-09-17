package arrays;
/*
https://leetcode.com/problems/sort-array-by-parity-ii/
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.
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

    public int[] sortArrayByParityII(int[] nums) {
        int[] sorted = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 1;

        for (int n : nums) {
            if (n % 2 == 0) {
                sorted[evenIndex] = n;
                evenIndex +=2;
            } else {
                sorted[oddIndex] = n;
                oddIndex +=2;
            }
        }

        return sorted;
    }

    public int[] sortArrayByParityII(int[] arr) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int a : arr) {
            if (a % 2 == 0) {
                even.add(a);
            } else {
                odd.add(a);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = even.get(0);
                even.remove(0);
            } else {
                arr[i] = odd.get(0);
                odd.remove(0);
            }
        }

        return arr;
    }
}
