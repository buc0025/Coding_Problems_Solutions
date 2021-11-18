package strings;
/*
https://edabit.com/challenge/vuxkHGZg8fuWCivPH

Write a function that returns true if you can use the letters of the first string to create the second string. Letters are case
sensitive.
 */

public class RansomLetter {

    public static boolean canBuild(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }

        int[] upper = new int[26];
        int[] lower = new int[26];
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (Character.isUpperCase(c)) {
                upper[c - 'A']++;
            } else {
                lower[c - 'a']++;
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (Character.isUpperCase(c)) {
                upper[c - 'A']--;
            } else {
                lower[c - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (upper[i] > 0) {
                count++;
            }
            if (lower[i] > 0) {
                count++;
            }
        }

        return count == str1.length() - str2.length();
    }
}
