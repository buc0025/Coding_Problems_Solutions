package strings;
/*
https://edabit.com/challenge/p5kyThBZDR7oJhjR7
Given a string, reverse all the words which have odd length. The even length words are not changed.
 */

public class ReverseOddLength {

    public static String reverseOdd(String str) {
        String[] arr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String a : arr) {
            if (a.length() % 2 != 0) {
                for (int i = a.length() - 1; i >= 0; i--) {
                    stringBuilder.append(a.charAt(i));
                }
            } else {
                stringBuilder.append(a);
            }

            stringBuilder.append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
