package strings;
/*
https://edabit.com/challenge/mc6KcMGkrSWP88dGu

Create a function that takes in a number as a string n and returns the number without trailing and leading zeros.

Trailing Zeros are the zeros after a decimal point which don't affect the value (e.g. the last three zeros in 3.4000 and 3.04000).
Leading Zeros are the zeros before a whole number which don't affect the value (e.g. the first three zeros in 000234 and 000230).
 */

public class RemoveLeading {

    // 4/18/2022 unfinished solution
    public static String removeLeadingTrailing(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '0') {
                n = n.substring(i);
                break;
            }
        }

        if (n.contains(".")) {
            for (int i = n.length() - 1; i >= 0; i--) {
                if (n.charAt(i) != '0') {
                    n = n.substring(0, i + 1);
                    break;
                }
            }
        }

        if (n.charAt(n.length() - 1) == '.') {
            n = n.substring(0, n.length() - 1);
        }

        return n;
    }
}
