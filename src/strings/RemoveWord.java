package strings;
/*
https://edabit.com/challenge/XxS3L2wDEKhi9Hw6W

Implement a method removeWord() that takes two string parameters:

sentence - the sentence you are to remove a word from.
word - the word you are to remove from the sentence.
Your method should take a string, sentence and remove word from it. It will return a new string without word in the sentence.
 */

public class RemoveWord {

    // 4/28/2022 solution
    public static String removeWord(final String sentence, final String word)
    {
        String[] arr = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String a : arr) {
            if (!a.equals(word)) {
                stringBuilder.append(a);
                stringBuilder.append(" ");
            }
        }

        if (arr[arr.length - 1].equals(word)) {
            stringBuilder.append(" ");
        }

        return stringBuilder.substring(0, stringBuilder.length()-1).toString();
    }
}
