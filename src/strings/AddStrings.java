package strings;
/*
https://leetcode.com/problems/add-strings/
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 */

public class AddStrings {
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
