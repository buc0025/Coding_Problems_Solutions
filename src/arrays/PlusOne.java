package arrays;
/*
https://leetcode.com/problems/plus-one/
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The
digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any
leading 0's.

Increment the large integer by one and return the resulting array of digits.
 */

public class PlusOne {

    // 5/12/2022 solution
    public int[] plusOne(int[] digits) {
        StringBuilder str = new StringBuilder();
        boolean carry = false;

        if (digits[digits.length - 1] + 1 == 10) {
            str.append(0);
            carry = true;
        } else {
            str.append(digits[digits.length - 1] + 1);
        }

        for (int i = digits.length - 2; i >= 0; i--) {
            if (carry) {
                int n = digits[i] + 1;
                if (n == 10) {
                    str.append(0);
                } else {
                    str.append(n);
                    carry = false;
                }
            } else {
                str.append(digits[i]);
            }
        }

        if (carry) {
            str.append(1);
        }

        int[] ans = new int[str.length()];
        String nums = str.reverse().toString();
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(nums.substring(i, i + 1));
        }

        return ans;
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1] += 1; // adding 1 to the last element in given array

        //adding numbers from end of the array to the front
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + carry > 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] += carry;
                carry = 0;
            }
        }

        // Returns digits if it's a valid number with no leading 0's
        if (digits[0] != 0) {
            return digits;
        }

        int[] arr = new int[digits.length + 1];
        arr[0] = 1; //if there's still a carry then new array starts with 1

        // the rest of the new array will equal to digits
        for (int i = 1; i < arr.length; i++) {
            arr[i] = digits[i - 1];
        }

        return arr;
    }

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
