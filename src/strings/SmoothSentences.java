package strings;
/*
https://edabit.com/challenge/SkY5Nw3rS7WvkQmFc

A smooth sentence is one where the last letter of each word is identical to the first letter the following word (and not case
sensitive, so "A" would be the same as "a").

The following would be a smooth sentence "Carlos swam masterfully" because "Carlos" ends with an "s" and swam begins with an "s"
and swam ends with an "m" and masterfully begins with an "m".

Create a function that determines whether the input sentence is a smooth sentence, returning a boolean value true if it is, false
if it is not.
 */

public class SmoothSentences {

    // Change sentence to upper or lower before logic
    public static boolean IsSmooth(String sentence) {
        String[] words = sentence.split(" ");
        char end = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            if (end != words[i].charAt(0)) {
                return false;
            }

            end = words[i].charAt(words[i].length() - 1);
        }

        return true;
    }
}
