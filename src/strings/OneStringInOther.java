package strings;
/*
https://edabit.com/challenge/ZoDHtyWfFPttuTiQR

Create a function that takes two strings and returns true if either of the strings appears at the very end of the other string.
Return false otherwise. The character * is a wildcard, so it can take the place of any character.
 */

public class OneStringInOther {

    public static boolean overlap(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 < len2) {
            for (int i = 0; i <= len2 - len1; i++) {
                if (str2.substring(i, i + len1).equals(str1)) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i <= len1 - len2; i++) {
                if (str1.substring(i, i + len2).equals(str2)) {
                    return true;
                }
            }
        }

        return false;
    }
}
