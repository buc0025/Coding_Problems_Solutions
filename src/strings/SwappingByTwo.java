package strings;
/*
https://edabit.com/challenge/Bt6tuyqL7ESZHpsec

Write a function that swaps the first pair (1st and 2nd characters) with the second pair (3rd and 4th characters) for every
quadruplet substring.
 */

public class SwappingByTwo {

    public static String swapTwo(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;
        int len = str.length();

        while (len >= 4) {
            String quad = str.substring(index, index + 4);
            stringBuilder.append(quad.charAt(2));
            stringBuilder.append(quad.charAt(3));
            stringBuilder.append(quad.charAt(0));
            stringBuilder.append(quad.charAt(1));

            index += 4;
            len -= 4;
        }

        for (int i = index; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }
}
