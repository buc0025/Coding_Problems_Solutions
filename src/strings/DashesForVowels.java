package strings;
/*
https://edabit.com/challenge/CKH5qJdtcFGNsdAfp

Create a function that takes a string and returns dashes on both sides of every vowel (a e i o u).
 */

public class DashesForVowels {

    // ReplaceAll could've been used to shorten solution
    public static String dashed(String str) {
        Set<Character> set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                stringBuilder.append('-');
                stringBuilder.append(str.charAt(i));
                stringBuilder.append('-');
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
