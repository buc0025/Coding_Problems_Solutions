package strings;
/*
https://edabit.com/challenge/n63bWFSAxgh3Qwhvn

Write a function that takes a string input and returns the string in a reversed case and order.
 */

public class Invert {

    // 6/2/2022 solution
    public static String invert(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char n = s.charAt(i);
            if (Character.isLetter(n)) {
                if (Character.isUpperCase(n)) {
                    stringBuilder.append(Character.toLowerCase(n));
                } else {
                    stringBuilder.append(Character.toUpperCase(n));
                }
            } else {
                stringBuilder.append(n);
            }
        }

        return stringBuilder.toString();
    }
}
