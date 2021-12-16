package strings;
/*
https://edabit.com/challenge/Yr2kTTb6zf5PNx6DE

Create a function that takes a string and replaces every nth instance of old_char with new_char. Your function will have four
parameters:

txt — The original input text to be processed.
nth — The nth instance to be replaced.
old_char — The character being replaced.
new_char — The character replacing old_char.
In other words, if txt is "abababa", nth is 3, old_char is "a" and new_char is "Z", you would replace the 3rd insrtance of "a"
with "Z", returning "ababZba".
 */

public class ReplaceNth {

    public static String replace_nth(String txt, int nth, String old_char, String new_char) {
        if (nth <= 0 || nth > (int) old_char.charAt(0)) {
            return txt;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < txt.length(); i++) {
            if (txt.substring(i, i + 1).equals(old_char)) {
                count++;
            }
            if (count == nth) {
                stringBuilder.append(new_char);
                count = 0;
            } else {
                stringBuilder.append(txt.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
