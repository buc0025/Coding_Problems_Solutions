package arrays;
/*
https://leetcode.com/problems/transpose-matrix/
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 */

public class TransposeMatrix {

    // 8/30/2022 solution
    public int[][] transpose(int[][] matrix) {
        int[][] arr = new int[matrix[0].length][matrix.length];
        int col = 0;

        for (int i = 0; i < matrix.length; i++) {
            int row = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                arr[row][col] = matrix[i][j];
                row++;
            }
            col++;
        }

        return arr;
    }

    public int[][] transpose(int[][] matrix) {
        int[][] arr = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[j][i] = matrix[i][j];
            }
        }

        return arr;
    }
}
