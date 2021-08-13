package arrays;
/*
https://leetcode.com/problems/matrix-block-sum/
Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c]
for:

i - k <= r <= i + k,
j - k <= c <= j + k, and
(r, c) is a valid position in the matrix.
 */

public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] arr = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                arr[i][j] = blockSum(mat, i, j, k, rowLen, colLen);
            }
        }

        return arr;
    }

    public static int blockSum(int[][] matrix, int i, int j, int k, int rowLen, int colLen) {
        int r = Math.max(i - k, 0);
        int rLen = Math.min(i + k, rowLen);
        int c = Math.max(j - k, 0);
        int cLen = Math.min(j + k, colLen);

        //Makes sure I don't go out of bounds
        if (rLen == rowLen) {
            rLen = rowLen - 1;
        }

        //Makes sure I don't go out of bounds
        if (cLen == colLen) {
            cLen = colLen - 1;
        }

        int sum = 0;

        for (int m = r; m <= rLen; m++) {
            for (int n = c; n <= cLen; n++) {
                sum += matrix[m][n];
            }
        }

        return sum;
    }
}
