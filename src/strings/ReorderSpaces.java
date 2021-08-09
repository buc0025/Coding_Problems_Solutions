package strings;
/*
https://leetcode.com/problems/rearrange-spaces-between-words/
You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase
English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized.
If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the
same length as text.

Return the string after rearranging the spaces.
 */

public class ReorderSpaces {

    // Attempt at rearranging space between words
    public String reorderSpaces(String text) {
        int space = 0;
        StringBuilder stringBuilder = new StringBuilder(); // String of how a sentence looks with just 1 spacing between words

        // counts number of spaces to be used later
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                space++;
            }
        }

        // Creating a normal sentence with 1 spacing between words
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                for (int j = i; j < text.length(); j++) {
                    if (text.charAt(j) != ' ') {
                        i = j;
                        break;
                    }
                }
                stringBuilder.append(' ');
            }
            stringBuilder.append(text.charAt(i));
        }

        // Deletes space at the beginning of sentence if present
        if (stringBuilder.charAt(0) == ' ') {
            stringBuilder = stringBuilder.deleteCharAt(0);
        }

        String[] words = stringBuilder.toString().split(" ");

        if (words.length == 1) {
            for (int i = 0; i < space; i++) {
                stringBuilder.append(' ');
            }
            return stringBuilder.toString();
        }

        int spaceBetween = space / (words.length - 1);
        int extraSpace = space % (words.length - 1);

        StringBuilder space1 = new StringBuilder();
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < spaceBetween; i++) {
            space1.append(' ');
        }

        //Adding the correct spacing in between words
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                sentence.append(words[i]);
            } else {
                sentence.append(words[i]);
                sentence.append(space1);
            }
        }

        //Adding extra space to the end if you cannot distribute all the spaces equally
        if (extraSpace != 0) {
            for (int i = 0; i < extraSpace; i++) {
                sentence.append(' ');
            }
        }

        return sentence.toString();
    }
}
