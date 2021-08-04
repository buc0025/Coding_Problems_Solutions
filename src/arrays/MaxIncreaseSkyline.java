package arrays;
/*
https://leetcode.com/problems/max-increase-to-keep-city-skyline/
There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical square prism. You are
given a 0-indexed n x n integer matrix grid where grid[r][c] represents the height of the building located in the block at row r
and column c.

A city's skyline is the the outer contour formed by all the building when viewing the side of the city from a distance. The
skyline from each cardinal direction north, east, south, and west may be different.

We are allowed to increase the height of any number of buildings by any amount (the amount can be different per building). The
height of a 0-height building can also be increased. However, increasing the height of a building should not affect the city's
skyline from any cardinal direction.

Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any
cardinal direction.
 */

public class MaxIncreaseSkyline {

    /*
    I created 2 matrices to hold the maximum values for x and y axis. A new matrix of the same size will hold the minimum value
    of x and y in the corresponding index. The indexes of the new matrix is then compared with the given matrix and any difference
    between the two will be added to the answer.
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int gLen = grid.length;
        int[][] xgrid = new int[gLen][gLen];
        int[][] ygrid = new int[gLen][gLen];

        for (int i = 0; i < gLen; i++) {
            int xMax = 0;
            int yMax = 0;
            for (int j = 0; j < gLen; j++) {
                if (grid[i][j] > xMax) {
                    xMax = grid[i][j];
                }
                if (grid[j][i] > yMax) {
                    yMax = grid[j][i];
                }
            }

            for (int x = 0; x < gLen; x++) {
                xgrid[i][x] = xMax;
                ygrid[x][i] = yMax;
            }
        }

        for (int i = 0; i < gLen; i++) {
            for (int j = 0; j < gLen; j++) {
                int min = Math.min(xgrid[i][j], ygrid[i][j]);
                ans += Math.abs(min - grid[i][j]);
            }
        }

        return ans;
    }
}
