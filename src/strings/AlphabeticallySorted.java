package strings;
/*
https://edabit.com/challenge/jc7nh6xMSZTBYvndz

A word is alphabetically sorted if all of the letters in it are in consecutive alphabetical order. Some examples of alphabetically
sorted words: abhors (a is before b, b is before h, h is before o, etc.), ghost, accent, hoop.

Create a function that takes in a sentence as input and returns true if there is at least one alphabetically sorted word inside
that has a minimum length of 3.
 */

public class AlphabeticallySorted {

    public static boolean isAlphabeticallySorted(String sentence) {
        sentence = sentence.substring(0, sentence.length() - 1).toLowerCase();
        String[] words = sentence.split(" ");

        for (String word : words) {
            if (word.length() >= 3) {
                boolean alpabetical = false;
                for (int i = 1; i < word.length(); i++) {
                    if ((int) word.charAt(i - 1) <= (int) word.charAt(i)) {
                        alpabetical = true;
                    } else {
                        alpabetical = false;
                        break;
                    }
                }

                if (alpabetical) {
                    return true;
                }
            }
        }

        return false;
    }
}
