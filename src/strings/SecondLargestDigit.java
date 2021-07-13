package strings;
/*
https://leetcode.com/problems/second-largest-digit-in-a-string/
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.
 */

public class SecondLargestDigit {

    /*
    Solution uses an array to represent the 10 possible digits in the string. The digit in the array is incremented once it's
    visited in the array. If the array contains more than 1 digit that's visited, we enter the while loop to find the second
    largest digit. The top solution doesn't use any extra space and does it in o(n) time. They check is char is a digit. If it is
    they have an int var and assign char - '0' to represent the number. They have int first and int second that both start off as
    -1. If the digit is greater than first then first is assigned as digit. If second digit is visited and not greater than first,
    second is assigned to it.
     */
    public int secondHighest(String s) {
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) {
            if (Integer.valueOf(s.charAt(i)) < 10) {
                int number = Integer.valueOf(s.substring(i, i + 1));
                arr[number]++;
            }
        }

        int digits = 0;
        int result = -1;

        for (int a : arr) {
            if (a > 0) {
                digits++;
            }
        }

        if (digits <= 1) {
            return result;
        }

        int place = 2;
        int index = 9;


        while (place > 0) {
            if (arr[index] > 0) {
                place--;
                result = index;
            }
            index--;
        }

        return result;
    }

    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                set.add(Integer.valueOf(s.substring(i, i + 1)));
            }
        }

        int result = -1;

        for (int n : set) {
            list.add(n);
        }

        for (int i = 0; i < list.size()-1; i++) {
            result = list.get(i);
        }

        return result;
    }
}
