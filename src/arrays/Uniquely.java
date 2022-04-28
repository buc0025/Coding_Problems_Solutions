package arrays;
/*
https://edabit.com/challenge/AGoRjorDpas63gqt6

You are given two inputs:
1. An array of abbreviations.
2. An array of words.
Write a function that returns true if each abbreviation uniquely identifies a word, and false otherwise.
 */

public class Uniquely {

    // 4/27/2022 solution
    public static boolean uniquely(String[] a, String[] w) {
        int[] occurrence = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int aLen = a[i].length();
            for (int j = 0; j < w.length; j++) {
                if (w[j].substring(0, aLen).equals(a[i])) {
                    occurrence[i]++;
                }
            }
        }

        for (int occur : occurrence) {
            if (occur == 0 || occur > 1) {
                return false;
            }
        }

        return true;
    }
}
