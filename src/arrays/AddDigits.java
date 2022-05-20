package arrays;
/*
https://leetcode.com/problems/add-digits/

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */

public class AddDigits {

    // 5/19/2022 solution
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        while (num > 9) {
            String number = String.valueOf(num);
            num = 0;
            for (int i = 0; i < number.length(); i++) {
                num += Integer.parseInt(number.substring(i, i + 1));
            }
        }

        return num;
    }
}
