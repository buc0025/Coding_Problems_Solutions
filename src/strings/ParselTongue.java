package strings;
/*
https://edabit.com/challenge/n3Sw2MEa4TkEhthgB

Hermione has come up with a precise formula for determining whether or not a phrase was ssspoken by a parssseltongue (a reference
from the Harry Potter universe; the language of ssserpents and those who can converse with them).

Each word in a sssentence must contain either:

Two or more consecutive instances of the letter "s" (i.e. must be together ss..), or...
Zero instances of the letter "s" by itself.
 */

public class ParselTongue {

    public static boolean isParselTongue(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        boolean parsel = false;

        for (String word : words) {
            int s = word.indexOf("s");
            if (s >= 0) {
                if (word.charAt(s + 1) == 's') {
                    parsel = true;
                } else {
                    return false;
                }
            }
        }

        return parsel;
    }
}
