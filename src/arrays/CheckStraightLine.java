package arrays;
/*
https://leetcode.com/problems/check-if-it-is-a-straight-line/
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these
points make a straight line in the XY plane.
 */

public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int yCount = 0;
        int xCount = 0;

        // There can't be more than 1 point on both x and y axis
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] == 0) {
                yCount++;
            }

            if (coordinates[i][1] == 0) {
                xCount++;
            }

            if (yCount > 1 && xCount > 1) {
                return false;
            }
        }

        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];
        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];
        double slope = 0;

        if (x2 - x1 != 0) {
            slope = (y2 - y1) / (x2 - x1);
        }

        for (int i = 1; i < coordinates.length; i++) {
            double x2a = coordinates[i][0];
            double y2a = coordinates[i][1];

            if (x2a - x1 == 0 && slope != 0) {
                return false;
            }

            if (x2a - x1 != 0) {
                if (slope != (y2a - y1) / (x2a - x1)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Passes 75/79 test cases
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        int slope = 0;

        if (x2 - x1 != 0) {
            slope = (y2 - y1) / (x2 - x1);
        }

        for (int i = 2; i < coordinates.length; i++) {
            int x1a = coordinates[i - 1][0];
            int y1a = coordinates[i - 1][1];
            int x2a = coordinates[i][0];
            int y2a = coordinates[i][1];

            if (x2a - x1a == 0) {
                return slope == 0;
            }

            if (slope != (y2a - y1a) / (x2a - x1a)) {
                return false;
            }
        }

        return true;
    }

    // Incorrect solution using 0(n2) on 7/15/2020
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates[1][0] - coordinates[1][1];

        for (int i = 1; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length-1; j++) {
                if (n != coordinates[i][j] - coordinates[i][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
