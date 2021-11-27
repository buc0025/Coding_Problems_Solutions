package strings;
/*
https://edabit.com/challenge/buctumjkfFWGx5iP6

Write a function that removes the last vowel in each word in a sentence.
 */

public class RemoveLastVowel {

    public static String removeLastVowel(String str) {
        String[] words = str.split(" ");
        StringBuilder sentence = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (String word : words) {
            int index = 0;
            String lower = word.toLowerCase();
            for (int i = lower.length() - 1; i >= 0; i--) {
                if (set.contains(lower.charAt(i))) {
                    index = i;
                    break;
                }
            }

            sentence.append(word.substring(0, index));
            sentence.append(word.substring(index + 1));
            sentence.append(" ");
        }

        return sentence.toString();
    }
}
