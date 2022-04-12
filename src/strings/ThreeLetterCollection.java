package strings;
/*
https://edabit.com/challenge/PkqSq3ea2bfJvF6Tk

Given a string, return a sorted array of words formed from the first three letters, then the next three letters, shifting by only
one.
 */

public class ThreeLetterCollection {

    // 4/11/2022 solution
    public static String[] threeLetterCollection(String s) {
        int arrLen = 0;
        if (s.length() == 3) {
            return new String[]{s};
        } else if (s.length() < 3) {
            return new String[]{};
        } else {
            arrLen = s.length() - 2;
        }

        String[] groupings = new String[arrLen];
        int index = 0;

        for (int i = 0; i < s.length() - 2; i++) {
            groupings[index] = s.substring(i, i + 3);
            index++;
        }

        Arrays.sort(groupings);
        return groupings;
    }
}
