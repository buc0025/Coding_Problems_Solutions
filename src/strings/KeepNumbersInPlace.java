package strings;
/*
https://edabit.com/challenge/AQr6ZPvSWzJ2cPTGt

Create a function that reverses letters in a string but keeps digits in their current order.
 */

public class KeepNumbersInPlace {

    public static String reverse(String str) {
        String letters = "";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                letters += str.substring(i, i + 1);
            }
        }

        int index = letters.length() - 1;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result += letters.substring(index, index + 1);
                index--;
            } else {
                result += str.substring(i, i + 1);
            }
        }

        return result;
    }
}
