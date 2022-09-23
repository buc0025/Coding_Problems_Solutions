package strings;
/*
https://leetcode.com/problems/long-pressed-name/
Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the
character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some
characters (possibly none) being long pressed.
 */

public class IsLongPressed {

    // 9/22/2022 incorrect solution
    public boolean isLongPressedName(String name, String typed) {
        int stop = 0;

        for (int i = 0; i < name.length(); i++) {
            for (int j = stop; j < typed.length(); j++) {
                if (name.charAt(i) == typed.charAt(j)) {
                    stop = j + 1;
                    break;
                }
                if (j == typed.length() - 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < name.length()) {
            if (j >= typed.length()) {
                return false;
            }
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }

        char c = name.charAt(i - 1);

        // Once the end of name is reached and letters are still remaining in typed, the rest of the letters should be the same
        // as the last character of name
        for (int k = j; k < typed.length(); k++) {
            if (typed.charAt(k) != c) {
                return false;
            }
        }

        return true;
    }
}
