package strings;
/*
https://leetcode.com/problems/add-strings/
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 */

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int num1Len = num1.length() -1;
        int num2Len = num2.length() - 1;
        int carry = 0;
        int sum = 0;

        // Adding the end element of both strings
        while (num1Len >= 0 && num2Len >= 0) {
            sum = (num1.charAt(num1Len) - '0') + (num2.charAt(num2Len)- '0') + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            num1Len--;
            num2Len--;
            stringBuilder.append(sum);
        }

        // Append the rest of num1
        while (num1Len >= 0) {
            sum = (num1.charAt(num1Len) - '0') + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            num1Len--;
            stringBuilder.append(sum);
        }

        // Append the rest of num2
        while (num2Len >= 0) {
            sum = (num2.charAt(num2Len) - '0') + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            num2Len--;
            stringBuilder.append(sum);
        }

        if (carry > 0) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();

        int sum = 0;
        int carry = 0;

        // Adding the strings from the end to the front
        while (num1Len >= 0 || num2Len >= 0) {
            if (num1Len >= 0 && num2Len >= 0) {
                sum = (num1.charAt(num1Len) - '0') + (num2.charAt(num2Len) - '0') + carry;
            }

            if (num1Len >= 0 && num2Len < 0) {
                sum = (num1.charAt(num1Len) - '0') + carry;
            }

            if (num2Len >= 0 && num1Len < 0) {
                sum = (num2.charAt(num2Len) - '0') + carry;
            }

            // If the sum of the end numbers is greater than 10, then 1 gets added to the next
            // sum of the numbers to the left.
            if (sum > 9) {
                stringBuilder.append(sum - 10);
                carry = 1;
            }
            else {
                stringBuilder.append(sum);
                carry = 0;
            }
            num1Len--;
            num2Len--;
        }

        // If the sum of the last 2 numbers is more than 10 then 1 gets appended to string
        if (carry > 0) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse().toString();
    }


    *******Solution only works for numbers smaller than Integer.MAX_VALUE**********
    public String addStrings(String num1, String num2) {
        int number = convertToInteger(num1) + convertToInteger(num2);
        return convertToString(number);
    }

    public String convertToString(int number) {
        String answer = "";
        String reverse = "";
        int end = 0;

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            end = number % 10;
            number /= 10;
            if (end == 1) {
                reverse += '1';
            }
            if (end == 2) {
                reverse += '2';
            }
            if (end == 3) {
                reverse += '3';
            }
            if (end == 4) {
                reverse += '4';
            }
            if (end == 5) {
                reverse += '5';
            }
            if (end == 6) {
                reverse += '6';
            }
            if (end == 7) {
                reverse += '7';
            }
            if (end == 8) {
                reverse += '8';
            }
            if (end == 9) {
                reverse += '9';
            }
            if (end == 0) {
                reverse += '0';
            }
        }

        for (int i = reverse.length() - 1; i >= 0; i--) {
            answer += reverse.charAt(i);
        }

        return answer;
    }

    public int convertToInteger(String string) {
        int number = 0;
        int base = string.length() - 1;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                number += 1 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '2') {
                number += 2 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '3') {
                number += 3 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '4') {
                number += 4 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '5') {
                number += 5 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '6') {
                number += 6 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '7') {
                number += 7 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '8') {
                number += 8 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '9') {
                number += 9 * (int) Math.pow(10, base);
                base--;
            }
            if (string.charAt(i) == '0') {
                number += 0 * (int) Math.pow(10, base);
                base--;
            }
        }
        return number;
    }
}
