package strings;
/*
https://edabit.com/challenge/GGijTCgukXqkYWX9Q

In this challenge, you must think about words as elastics. What happens when do you tend an elastic applying a constant traction
force at both ends? Every part (or letter, in this case) of the elastic will expand, with the minimum expansion at the ends, and
the maximum expansion in the center.

If the word has an odd length, the effective central character of the word will be the pivot that splits the word into two halves.
 */

public class Elasticize {

    // 5/21/2022 solution
    public static String elasticize(String word) {
        if (word.length() < 3) {
            return word;
        }

        int half = word.length() / 2;
        int left = 1;
        int right = half;

        StringBuilder leftWord = new StringBuilder();
        StringBuilder rightWord = new StringBuilder();

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < left; j++) {
                leftWord.append(word.charAt(i));
            }
            left++;
        }

        if (word.length() % 2 == 0) {

            for (int i = half; i < word.length(); i++) {
                for (int j = right; j > 0; j--) {
                    rightWord.append(word.charAt(i));
                }
                right--;
            }
        } else {
            for (int i = half; i < word.length(); i++) {
                for (int j = right; j >= 0; j--) {
                    rightWord.append(word.charAt(i));
                }
                right--;
            }
        }
        return leftWord.toString() + rightWord.toString();
    }
}
