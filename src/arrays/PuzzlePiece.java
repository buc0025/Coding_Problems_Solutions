package arrays;
/*
https://edabit.com/challenge/jtFNMktij8FcH6zna

Write a function that takes two arrays and adds the first element in the first array with the first element in the second array,
the second element in the first array with the second element in the second array, etc, etc. Return true if all element
combinations add up to the same number. Otherwise, return false.
 */

public class PuzzlePiece {

    public static boolean puzzlePieces(int[][] n) {
        if (n[0].length != n[1].length) {
            return false;
        }

        int sum = n[0][0] + n[1][0];

        for (int i = 0; i < n[0].length; i++) {
            if (n[0][i] + n[1][i] != sum) {
                return false;
            }
        }

        return true;
    }
}
