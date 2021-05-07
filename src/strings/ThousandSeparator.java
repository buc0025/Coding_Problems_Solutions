package strings;
/*
https://leetcode.com/problems/thousand-separator/
Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 */

public class ThousandSeparator {

    public String thousandSeparator(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        String num = String.valueOf(n);

        if (num.length() < 4) {
            return num;
        }

        int place = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            stringBuilder.append(num.charAt(i));
            if (place % 3 == 0) {
                stringBuilder.append('.');
            }
            place++;
        }

        stringBuilder.reverse();

        if (stringBuilder.charAt(0) == '.') {
            return stringBuilder.substring(1);
        } else {
            return stringBuilder.toString();
        }
    }
}
