package arrays;
/*
https://leetcode.com/problems/plus-one/
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The
digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any
leading 0's.

Increment the large integer by one and return the resulting array of digits.
 */

public class PlusOne {

    // Solution only passes half of the test cases because it doesn't account for integers bigger than Integer.MAX
    public int[] plusOne(int[] digits) {
        int place = 0;
        int val = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            double num = Math.pow(10, place) * digits[i];
            val += num;
            place++;
        }

        int size = 0;
        int clone = val;

        while (clone > 0) {
            clone /= 10;
            size++;
        }

        int[] arr = new int[size];

        while (val > 0) {
            arr[size - 1] = val % 10;
            val /= 10;
            size--;

        }

        return arr;
    }
}
