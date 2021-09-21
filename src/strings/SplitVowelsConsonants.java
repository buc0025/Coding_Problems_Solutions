package strings;
/*
https://edabit.com/challenge/jfRHGwHMZcnzZm9JL

Write a function that takes a string, breaks it up and returns it with vowels first, consonants second. For any character that's
not a vowel (like special characters or spaces), treat them like consonants.
 */

public class SplitVowelsConsonants {

    public static String split(String str) {
        StringBuilder consonants = new StringBuilder();
        StringBuilder vowels = new StringBuilder();

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (set.contains(letter)) {
                vowels.append(letter);
            } else {
                consonants.append(letter);
            }
        }

        return vowels.append(consonants).toString();
    }
}
