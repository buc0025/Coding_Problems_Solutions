package strings;
/*
https://leetcode.com/problems/goat-latin/
You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters
only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as
follows:

If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
Return the final sentence representing the conversion from sentence to Goat Latin.
 */

import java.util.HashSet;

public class GoatLatin {

    // 8/11/2022 solution
    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < vowels.length(); i++) {
            set.add(vowels.charAt(i));
        }

        StringBuilder stringbuilder = new StringBuilder();
        String[] words = sentence.split(" ");
        int a = 1;

        for (String word : words) {
            if (set.contains(word.charAt(0))) {
                stringbuilder.append(word);
                stringbuilder.append("ma");
            } else {
                stringbuilder.append(word.substring(1));
                stringbuilder.append(word.charAt(0));
                stringbuilder.append("ma");
            }

            for (int i = 0; i < a; i++) {
                stringbuilder.append("a");
            }

            a++;
            stringbuilder.append(" ");
        }

        int len = stringbuilder.length();

        return stringbuilder.substring(0, len - 1).toString();
    }

    public String ToGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder stringbuilder = new StringBuilder();
        HashSet<Character> set = new HashSet<Character>();

        String vowels = "AEIOUaeiou";

        for (int i = 0; i < vowels.length(); i++)
        {
            set.add(vowels.charAt(i));
        }

        int count = 1;

        for (String word : arr)
        {
            if (set.contains(word.charAt(0)))
            {
                stringbuilder.append(word);
            } else
            {
                stringbuilder.append(word.substring(1));
                stringbuilder.append(word.charAt(0));
            }

            stringbuilder.append("ma");

            for (int i = 0; i < count; i++)
            {
                stringbuilder.append("a");
            }

            count++;
            stringbuilder.append(" ");
        }

        return stringbuilder.toString().substring(0, stringbuilder.length() - 1);
    }
}
