package strings;
/*
https://edabit.com/challenge/PkqSq3ea2bfJvF6Tk

Given a string, return a sorted array of words formed from the first three letters, then the next three letters, shifting by only
one.
 */

public class ThreeLetterCollection {

    // 4/10/2022 unfinished solution
    public static String[] threeLetterCollection(String s) {
        int arrLen = 0;
        if (s.length() == 3) {
            return new String[]{s};
        } else if (s.length() < 3) {
            return new String[]{};
        } else {
            arrLen = s.length() - 2;
        }
    }
}
