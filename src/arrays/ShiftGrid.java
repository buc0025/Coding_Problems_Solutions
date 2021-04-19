package arrays;
/*
https://leetcode.com/problems/shift-2d-grid/
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.
 */

public class ShiftGrid {
    /*
    Was able to solve by converting answer into 2D array instead of List<List<Integer>>. Had to look at solution to convert
    2D array into list. Most difficult part was finding the new row for the shifted element. New column was simple arithmetic.
     */

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> list = new ArrayList<>();

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int column = (j + k) % n;
                int row = ((i * n + j) + k) % (m * n) / n;
                arr[row][column] = grid[i][j];
            }
        }

        for (int[] row : arr) {
            List<Integer> listRow = new ArrayList<>();
            list.add(listRow);
            for (int r : row) {
                listRow.add(r);
            }
        }

        return list;
    }
}
