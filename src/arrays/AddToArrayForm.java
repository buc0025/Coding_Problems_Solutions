package arrays;
/*
https://leetcode.com/problems/add-to-array-form-of-integer/
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 */

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

    /*
    Adding the 1's digits from array and k to see if sum is greater than 9. If the sum of the two digits is greater than 9, I
    carry over 1 to add to the next two digits. The sum of the digits are being appended at every place value until the end.
    The string is then reversed and added into a list.
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        int numIndex = num.length - 1;
        int carry = 0;
        int n;
        int kNum;
        int ans;

        while (k > 0 || numIndex >= 0) {
            if (numIndex < 0) {
                n = 0;
            } else {
                n = num[numIndex];
            }

            kNum = k % 10;
            ans = n + kNum + carry;

            if (ans >= 10) {
                stringBuilder.append(ans - 10);
                carry = 1;
            } else {
                stringBuilder.append(ans);
                carry = 0;
            }
            numIndex--;
            k /= 10;
        }

        if (carry == 1) {
            stringBuilder.append(1);
        }

        String reverse = stringBuilder.reverse().toString();

        for (int i = 0; i < reverse.length(); i++) {
            int number = Integer.valueOf(reverse.substring(i, i + 1));
            list.add(number);
        }

        return list;
    }
}
