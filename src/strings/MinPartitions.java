package strings;
/*
https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100
are deci-binary, while 112 and 3001 are not.

Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so
that they sum up to n.
 */

public class MinPartitions {

    // 3/31/2022 solution
    public int minPartitions(String n) {
        int max = 0;

        for (int i = 0; i < n.length(); i++) {
            int number = n.charAt(i) - 48;
            max = Math.max(number, max);
        }

        return max;
    }

    // Shortened runtime by traversing through string from both ends
    public int minPartitions(String n) {
        int max = 0;
        int l = 0;
        int r = n.length() - 1;

        while (l <= r) {
            int lVal = Integer.valueOf(n.substring(l, l + 1));
            int rVal = Integer.valueOf(n.substring(r, r + 1));

            if (lVal == 9 || rVal == 9) {
                return 9;
            }

            max = Math.max(max, Math.max(lVal, rVal));

            l++;
            r--;
        }

        return max;
    }

    public int minPartitions(String n) {
        int max = 0;

        for (int i = 0; i < n.length(); i++) {
            int val = Integer.valueOf(n.substring(i, i + 1));
            max = Math.max(val, max);
            if (max == 9) {
                return 9;
            }
        }

        return max;
    }
}
