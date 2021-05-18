package strings;
/*
https://leetcode.com/problems/detect-capital/
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.
 */

public class DetectCapital {

    /*
    There's only two conditions I need to look out for and that's if all the letters are the same case and if the first letter is
    upper case while the rest are lower case.
     */
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int upper = 0;
        int lower = 0;
        boolean firstUp = Character.isUpperCase(word.charAt(0));

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upper++;
            } else {
                lower++;
            }
        }

        if (upper == len || lower == len) {
            return true;
        } else if (firstUp && len - 1 == lower) {
            return true;
        } else {
            return false;
        }
    }
}
