package strings;
/*
https://edabit.com/challenge/wunaXvZw3WctYioeC

Someone has attempted to censor my strings by replacing every vowel with a *, l*k* th*s. Luckily, I've been able to find the
vowels that were removed.

Given a censored string and a string of the censored vowels, return the original uncensored string.
 */

public class CensoredStrings {

    public static String Uncensor(String txt, String vowels) {
        if (vowels.length() == 0) {
            return txt;
        }

        int index = 0;
        var phrase = new StringBuilder();

        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '*') {
                phrase.append(vowels.charAt(index));
                index++;
            }
            else {
                phrase.append(txt.charAt(i));
            }
        }

        return phrase.toString();
    }
}
