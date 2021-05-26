package strings;
/*
https://leetcode.com/problems/sorting-the-sentence/
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of
lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 */

public class SortSentence {

    /*
    Top solution turned the string into an array by splitting the spaces. They joined each word from the substring(0, length() -1).
    My solution had the same idea except I ended up using two arrays and an additional loop to form the new string.
     */
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        String[] arr1 = new String[arr.length];

        for (int i = 0; i < arr1.length; i++) {
            int index = Integer.valueOf(arr[i].substring(arr[i].length() - 1));

            arr1[index - 1] = arr[i];
        }

        for (int i = 0; i < arr1.length; i++) {
            String word = arr1[i].substring(0, arr1[i].length() - 1);
            if (i == arr1.length - 1) {
                stringBuilder.append(word);
            } else {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
