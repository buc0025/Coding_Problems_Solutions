package strings;
/*
https://edabit.com/challenge/mtrBW4w2Bkum4bGt5

Create a function that will remove any repeated charcter(s) in a word passed to the function. Not just consecutive characters, but
characters repeating anywhere in the string.
 */

public class RemoveRepeatedChars {

    public static String unrepeated(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                result.append(str.charAt(i));
            }
            set.add(str.charAt(i));
        }

        return result.toString();
    }
}
