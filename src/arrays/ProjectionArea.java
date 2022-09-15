package arrays;
/*
https://leetcode.com/problems/projection-area-of-3d-shapes/

You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).

We view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane. We are viewing the "shadow" when
looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.
 */

public class ProjectionArea {

    // 9/14/2022 solution
    public int projectionArea(int[][] grid) {
        int top = 0;
        int front = 0;
        int side = 0;

        for (int i = 0; i < grid.length; i++) {
            int maxSide = 0;
            int maxFront = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    top++;
                }
                if (grid[i][j] > maxSide) {
                    maxSide = grid[i][j];
                }
                if (grid[j][i] > maxFront) {
                    maxFront = grid[j][i];
                }
            }
            side += maxSide;
            front += maxFront;
        }

        return top + front + side;
    }
}
