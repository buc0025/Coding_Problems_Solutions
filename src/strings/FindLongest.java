package strings;
/*
https://edabit.com/challenge/MYtinBHDSk4Bk7HnH

Write a recursive function that will return the longest word in a sentence. In cases where more than one word is found, return the
first one.
 */

public class FindLongest {

    // 6/6/2022 solution
    public static String findLongest(String sentence) {
        String[] words = sentence.split(" ");
        String maxWord = "";

        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            int start = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    start = i;
                    break;
                }
            }

            for (int i = start; i < word.length(); i++) {
                if (Character.isLetter(word.charAt(i))) {
                    stringBuilder.append(word.charAt(i));
                } else {
                    break;
                }
            }

            if (stringBuilder.length() > maxWord.length()) {
                maxWord = stringBuilder.toString();
            }
        }

        return maxWord.toLowerCase();
    }
}
