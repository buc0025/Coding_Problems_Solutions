package arrays;
/*
https://leetcode.com/problems/rectangle-overlap/
An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left
corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and
its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the
corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.
 */

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Checks to see if right and left side of rectangles overlap
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) {
            return false;
        }
        // Checks to see if top and bottom side of rectangles overlap
        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }
        // Checks to see if they're lines
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        return true;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // The idea is to focus on the sides of one rectangle instead of the area inside
        // Checks the right and left side of rectangle 1
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) {
            return false;
        }
        // Checks the top and bottom of rectangle 1
        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }

        return isNotALine(rec1, rec2);
    }

    // Some test cases use lines instead of rectangles
    public boolean isNotALine(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3]) {
            return false;
        }

        if (rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        return true;
    }

    *****Incorrect attempt at random mock interview*******

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // x-axis of both rectangles
        int r1x1 = rec1[0];
        int r1x2 = rec1[2];
        int r2x1 = rec2[0];
        int r2x2 = rec2[2];

        // y-axis of both rectangles
        int r1y1 = rec1[1];
        int r1y2 = rec1[3];
        int r2y1 = rec2[1];
        int r2y2 = rec2[3];

        return xOverlap(r1x1, r1x2, r2x1, r2x2) && yOverlap(r1y1, r1y2, r2y1, r2y2);
    }

    // Method checks if rectangle 2's x-axis overlaps with rectangle 1's x-axis
    public boolean xOverlap(int r1x1, int r1x2, int r2x1, int r2x2) {
        boolean overlap = false;

        if (r2x1 > r1x1 && r2x1 < r1x2) {
            overlap = true;
        }
        if (r2x2 > r1x1 && r2x2 < r1x2) {
            overlap = true;
        }

        return overlap;
    }

    // Method checks if rectangle 2's y-axis overlaps with rectangle 1's y-axis
    public boolean yOverlap(int r1y1, int r1y2, int r2y1, int r2y2) {
        boolean overlap = false;

        if (r2y1 > r1y1 && r2y1 < r1y2) {
            overlap = true;
        }
        if (r2y1 <= r1y1 && r2y2 < r1y2) {
            overlap = true;
        }
        if (r2y2 > r1y1 && r2y2 < r1y2) {
            overlap = true;
        }

        return overlap;
    }
}
