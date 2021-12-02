package strings;
/*
https://edabit.com/challenge/7r3uQADjtXEk7qirj

Given a number, return a string which is formatted into US Dollars and cents!

Remember that:

You should round to two digits after the decimal point (even for integers).
Thousandths should be separated by commas.
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MoneyFormatting {

    public static String dolladollaBills(double money) {
        String cents = ".00";
        boolean negative = false;

        // Formats the cents of the dollar amount
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        String s = df.format(money);

        // Removes '-' from string if present and will add it at the end when dollar amount is determined
        if (s.charAt(0) == '-') {
            s = s.substring(1);
            negative = true;
        }

        // Finds the cents if present to check if pennies are present and add 0 to end if not
        if (s.contains(".")) {
            int decimal = s.indexOf(".");
            int len = s.length();
            if (len - decimal == 2) {
                cents = s.substring(decimal) + "0";
            } else {
                cents = s.substring(decimal);
            }
            s = s.substring(0, decimal);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int comma = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (comma == 3) {
                stringBuilder.append(",");
                comma = 0;
            }
            stringBuilder.append(s.charAt(i));
            comma++;
        }

        String result = "";

        if (negative) {
            result += "-$" + stringBuilder.reverse().toString() + cents;
        } else {
            result += "$" + stringBuilder.reverse().toString() + cents;
        }

        return result;
    }
}
