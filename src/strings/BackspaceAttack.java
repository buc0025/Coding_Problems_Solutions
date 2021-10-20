package strings;
/*
https://edabit.com/challenge/hYKyiwgw9Ni5ELtDL


Suppose a hash # represents the BACKSPACE key being pressed. Write a function that transforms a string containing # into a string
without any #.
 */

public class BackspaceAttack {

    public static String erase(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int len = stringBuilder.length();
            if (str.charAt(i) == '#' && len > 0) {
                stringBuilder.deleteCharAt(len - 1);
            } else if (str.charAt(i) != '#') {
                stringBuilder.append(str.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
