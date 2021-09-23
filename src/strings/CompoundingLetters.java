package strings;
/*
https://edabit.com/challenge/tgjFboGwDEHY4Wn5S

Create a function that takes a string and returns a new string with each new character accumulating by +1. Separate each set with
a dash.
 */

public class CompoundingLetters {

    public static String accum(String str) {
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.substring(i, i + 1).toUpperCase());

            for (int j = 0; j < count - 1; j++) {
                stringBuilder.append(str.charAt(i));
            }

            stringBuilder.append('-');
            count++;
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
