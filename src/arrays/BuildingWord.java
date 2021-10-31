package arrays;
/*
https://edabit.com/challenge/Eiyu2SZk9rgdp5gZd

You are given an input list of strings, ordered by ascending length.

Write a function that returns True if, for each pair of consecutive strings, the second string can be formed from the first by
adding a single letter either at the beginning or end.
 */

public class BuildingWord {

    public static boolean canBuild(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int len = arr[i].length();
            String beginning = arr[i].substring(0, len - 1);
            String end = arr[i].substring(1);
            String previous = arr[i - 1];

            if (!previous.equals(beginning) && !previous.equals(end)) {
                return false;
            }
        }

        return true;
    }
}
