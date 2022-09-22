package arrays;
/*
https://leetcode.com/problems/sort-array-by-parity-ii/

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.
 */

public class SortArrayByParityII {

    // 9/21/2022 solution
    public int[] sortArrayByParityII(int[] nums) {
        int[] even = new int[nums.length / 2];
        int[] odd = new int[nums.length / 2];

        int eIndex = 0;
        int oIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                even[eIndex++] = nums[i];
            } else {
                odd[oIndex++] = nums[i];
            }
        }

        int index = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            nums[index++] = even[i];
            nums[index++] = odd[i];
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
