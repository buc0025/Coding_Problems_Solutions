package strings;
/*
https://leetcode.com/problems/add-binary/
Given two binary strings a and b, return their sum as a binary string.
 */

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int carry = 0;

        while (aLen >= 0 && bLen >= 0) {
            int sum = (a.charAt(aLen) - '0') + (b.charAt(bLen) - '0') + carry;
            if (sum == 3) {
                carry = 1;
                stringBuilder.append('1');
            } else if (sum == 2) {
                carry = 1;
                stringBuilder.append('0');
            } else if (sum == 1) {
                carry = 0;
                stringBuilder.append('1');
            } else {
                carry = 0;
                stringBuilder.append('0');
            }
            aLen--;
            bLen--;
        }

        while (aLen >= 0) {
            int sum = (a.charAt(aLen) - '0') + carry;
            if (sum == 2) {
                carry = 1;
                stringBuilder.append('0');
            } else if (sum == 1) {
                carry = 0;
                stringBuilder.append('1');
            } else {
                carry = 0;
                stringBuilder.append('0');
            }
            aLen--;
        }

        while (bLen >= 0) {
            int sum = (b.charAt(bLen) - '0') + carry;
            if (sum == 2) {
                carry = 1;
                stringBuilder.append('0');
            } else if (sum == 1) {
                carry = 0;
                stringBuilder.append('1');
            } else {
                carry = 0;
                stringBuilder.append('0');
            }
            bLen--;
        }

        if (carry == 1) {
            stringBuilder.append('1');
        }

        return stringBuilder.reverse().toString();
    }

    /* Solution passes test cases for binary numbers up to max value of long. Need to come up with different solution that only
    involves adding binary without the decimal value.
     */
    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        }

        long bin1 = toDec(a);
        long bin2 = toDec(b);
        StringBuilder stringBuilder = new StringBuilder();

        long n = bin1 + bin2;
        int index = 0;
        long[] arr = new long[1000];

        while (n > 0) {
            arr[index] = n % 2;
            n /= 2;
            index++;
        }

        for (int i = index - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }

    public long toDec(String a) {
        long dec = 0;
        int base = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                dec += Math.pow(2, base);
            }

            base++;
        }

        return dec;
    }
}
