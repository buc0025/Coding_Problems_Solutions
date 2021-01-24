package arrays;
/*
https://leetcode.com/problems/sort-array-by-parity-ii/
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.
 */

public class SortByParity {

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
