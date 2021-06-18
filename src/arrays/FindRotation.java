package arrays;
/*
https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in
90-degree increments, or false otherwise.
 */

public class FindRotation {

    /*
    The idea is to match the elements in both matrices. I only rotate one of them to match with the target matrix that never rotates.
    I compared the matrices after rotating mat to the left, right, upside down, and right side up.
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        StringBuilder matUp = new StringBuilder();
        StringBuilder matLeft = new StringBuilder();
        StringBuilder matRight = new StringBuilder();
        StringBuilder matUpsideDown = new StringBuilder();
        StringBuilder targetString = new StringBuilder();

        // right side up
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                targetString.append(target[i][j]);
                matUp.append(mat[i][j]);
            }
        }

        if (targetString.toString().equals(matUp.toString())) {
            return true;
        }

        //left turn
        for (int i = target.length - 1; i >= 0; i--) {
            for (int j = 0; j < target.length; j++) {
                matLeft.append(mat[j][i]);
            }
        }

        if (targetString.toString().equals(matLeft.toString())) {
            return true;
        }

        //right turn
        for (int i = 0; i < target.length; i++) {
            for (int j = target.length - 1; j >= 0; j--) {
                matRight.append(mat[j][i]);
            }
        }

        if (targetString.toString().equals(matRight.toString())) {
            return true;
        }

        //upside down
        for (int i = target.length - 1; i >= 0; i--) {
            for (int j = target.length - 1; j >= 0; j--) {
                matUpsideDown.append(mat[i][j]);
            }
        }

        if (targetString.toString().equals(matUpsideDown.toString())) {
            return true;
        }

        return false;
    }
}
