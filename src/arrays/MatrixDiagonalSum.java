package arrays;
/*
https://leetcode.com/problems/matrix-diagonal-sum/
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part
of the primary diagonal.
 */

public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int sum = 0;

        int topLeft = 0;
        int topRight = mat.length - 1;

        int botLeft = 0;
        int botRight = mat.length - 1;

        // Finds the diagonal points of the top half of the matrix
        for (int i = 0; i < mat.length && topLeft < topRight; i++) {
            sum += mat[i][topLeft] + mat[i][topRight];
            topLeft++;
            topRight--;
        }

        // Finds the diagonal points of the bottom half of the matrix
        for (int i = mat.length - 1; i >= 0 && botLeft < botRight; i--) {
            sum += mat[i][botLeft] + mat[i][botRight];
            botLeft++;
            botRight--;
        }

        if (mat.length % 2 == 0) {
            return sum;
        } else {
            // Adds the middle element of the matrix
            return sum + mat[mat.length/2][mat.length/2];
        }
    }
}
