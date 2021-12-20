package strings;
/*
https://edabit.com/challenge/f72omtBYFEBotgdEX

Create a function that takes a number and return a string with the number in expanded notation (AKA expanded form). See the
resources tab for details on expanded notation.
 */

public class ExpandedNotation {

    public static String expand(long num) {
        String number = String.valueOf(num);
        int zeroes = number.length() - 1;
        String expand = "";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') {
                zeroes--;
                continue;
            }
            expand += number.substring(i, i + 1);
            for (int j = 0; j < zeroes; j++) {
                expand += "0";
            }
            if (i != number.length() - 1) {
                expand += " + ";
            }
            zeroes--;
        }

        if (expand.substring(expand.length() - 3).equals(" + ")) {
            return expand.substring(0, expand.length() - 3);
        }

        return expand;
    }

    // Solution doesn't deal with zeroes in given num
    public static String expand(long num) {
        String number = String.valueOf(num);
        int zeroes = number.length() - 1;
        StringBuilder expanded = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            expanded.append(number.charAt(i));
            for (int j = 0; j < zeroes; j++) {
                expanded.append(0);
            }

            if (i != number.length() - 1) {
                expanded.append(" + ");
            }

            zeroes--;
        }

        return expanded.toString();
    }
}
