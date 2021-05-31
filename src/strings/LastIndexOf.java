package strings;
/*
Mock interview question from Jason asking to return the index of the last occurrence of the string in a sentence.
Example: word = "hello"  sentence = "hello stanley hello hello"
There are 3 hello's in the sentence and we're looking for the index of the last one which would be 20. If the word is not found
in the sentence then return -1
 */

public class LastIndexOf {

    /*
    Sliding window method is used to compare the given word to the words in the sentence. We start at the end of the sentence first
    since we're looking for the last occurrence.
     */
    public static int lastIndexOf(String word, String sentence) {
        int wLen = word.length();
        int sLen = sentence.length();

        for (int i = sLen - wLen; i >= 0; i--) {
            int match = 0;
            for (int j = 0; j < wLen; j++) {
                if (sentence.charAt(j + i) == word.charAt(j)) {
                    match++;
                }
            }
            if (match == wLen) {
                return i;
            }
        }

        return -1;
    }
}
