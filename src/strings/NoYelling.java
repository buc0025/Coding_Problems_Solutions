package strings;
/*
https://edabit.com/challenge/33tRK98geLPcf73PF

Create a function that transforms sentences ending with multiple question marks ? or exclamation marks ! into a sentence only
ending with one without changing punctuation in the middle of the sentences.
 */

public class NoYelling {

    public static String noYelling(String phrase) {
        boolean exclaim = false;
        boolean question = false;
        int index = 0;

        for (int i = phrase.length() - 1; i >= 0; i--) {
            if (phrase.charAt(i) == '!') {
                exclaim = true;
            } else if (phrase.charAt(i) == '?') {
                question = true;
            } else {
                index = i;
                break;
            }
        }

        StringBuilder sentence = new StringBuilder(phrase.substring(0, index + 1));

        if (exclaim) {
            sentence.append('!');
        } else if (question) {
            sentence.append('?');
        }

        return sentence.toString();
    }
}
