package strings;
/*
https://edabit.com/challenge/GGijTCgukXqkYWX9Q

In this challenge, you must think about words as elastics. What happens when do you tend an elastic applying a constant traction
force at both ends? Every part (or letter, in this case) of the elastic will expand, with the minimum expansion at the ends, and
the maximum expansion in the center.

If the word has an odd length, the effective central character of the word will be the pivot that splits the word into two halves.
 */

public class Elasticize {

    // 5/20/2022 unfinished solution
    public static String elasticize(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        if (word.length() < 3) {
            System.out.println(word);
        }

        int half = word.length() / 2;

        if (word.length() % 2 == 0) {
            int left = 1;
            int right = half;
            for (int i = 0; i < half; i++) {
                for (int j = 0; j < left; j++) {
                    stringBuilder.append(word.charAt(i));
                }
                left++;
            }
            for (int i = half; i < word.length(); i++) {
                for (int j = right; j >= 0; j--) {
                    stringBuilder.append(word.charAt(i));
                }
                right--;
            }
        }
    }
}
