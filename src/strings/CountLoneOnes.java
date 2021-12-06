package strings;
/*
https://edabit.com/challenge/YHa95Qi8yXTu8oQLL

Create a function which counts the cardinality of lone 1s in a given number. Lone means the number doesn't appear more than once
in a row.
 */

public class CountLoneOnes {

    public static int countLoneOnes(long n) {
        String num = String.valueOf(n);
        int count = 0;
        int len = num.length();

        if (len == 1 && num.charAt(0) == '1') {
            return 1;
        }

        if (len > 1) {
            if (num.charAt(0) == '1' && num.charAt(1) != '1') {
                count++;
            }
            if (num.charAt(len - 1) == '1' && num.charAt(len - 2) != '1') {
                count++;
            }
        }

        for (int i = 1; i < len - 1; i++) {
            if (num.charAt(i) == '1' && num.charAt(i - 1) != '1' && num.charAt(i + 1) != '1') {
                count++;
            }
        }

        return count;
    }
}
