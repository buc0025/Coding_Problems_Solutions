package arrays;
/*
https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci]
represents a 0-indexed location to perform some increment operations on the matrix.

For each location indices[i], do both of the following:

Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in
indices.
 */

public class OddCells {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int odd = 0;

        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int col = indices[i][1];

            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
            }

            for (int k = 0; k < m; k++) {
                matrix[k][col]++;
            }
        }

        for (int i = 0; i < matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    odd++;
                }
            }
        }

        return odd;
    }
}
