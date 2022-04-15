package strings;
/*
https://edabit.com/challenge/6mLZjPrNFrfGfdwqa

A magic sigil is a glyph which represents a desire one wishes to manifest in their lives. There are many ways to create a sigil,
but the most common is to write out a specific desire (e.g. "I HAVE WONDERFUL FRIENDS WHO LOVE ME"), remove all vowels, remove any
duplicate letters (keeping the last occurence), and then design a glyph from what remains.
 */

public class Sigilize {

    // 4/14/2022 unfinished solution
    public static String sigilize(String desire) {
        desire = desire.toUpperCase();
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        String backwards = "";
        String word = "";

        for (int i = 0; i < desire.length(); i++) {
            if (desire.charAt(i) != ' ' && !vowels.contains(desire.charAt(i))) {
                word += desire.substring(i , i + 1);
            }
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            String letter = word.substring(i, i + 1);
            String leftover = word.substring(0, i);
            if (!leftover.contains(letter)) {
                backwards += letter;
            }
            System.out.println(letter);
        }
    }
}
