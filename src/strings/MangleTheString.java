package strings;
/*
https://edabit.com/challenge/BJkkDwsZrB8SFTAQ2

Create a function that takes a string and replaces every letter with the letter following it in the alphabet ("c" becomes "d", "z"
becomes "a", "b" becomes "c", etc). Then capitalize every vowel (a, e, i, o, u) and return the new modified string.
 */

public class MangleTheString {

    public static String mangle(String str) {
        StringBuilder phrase = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int n = (int) c + 1;

            if (Character.isLetter(c)) {
                if (n == 91 || n == 123) {
                    phrase.append('A');
                } else if (set.contains((char) n)) {
                    phrase.append((char) (n -32));
                } else if (c == ' ') {
                    phrase.append(' ');
                } else {
                    phrase.append((char) n);
                }
            } else {
                phrase.append(c);
            }
        }

        return phrase.toString();
    }
}
