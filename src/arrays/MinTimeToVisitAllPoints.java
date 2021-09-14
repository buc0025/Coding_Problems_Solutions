package arrays;
/*
https://leetcode.com/problems/minimum-time-visiting-all-points/
On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all
the points in the order given by points.

You can move according to these rules:

In 1 second, you can either:
move vertically by one unit,
move horizontally by one unit, or
move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.
 */

public class MinTimeToVisitAllPoints {

    /* It doesn't matter if the next point is to the left or right of the current as long as we know how far away it is
    horizontally. The same goes for up and down. Moving diagonally would be the shortest route if the points are not on the same
    axis. To get the time for diagonal movements, we take the max of horizontal and vertical moves. This is still less than adding
    both moves together.
     */

    public int minTimeToVisitAllPoints(int[][] points) {
        // Starting points which will change with each iteration
        int startX = points[0][0];
        int startY = points[0][1];

        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int vertical = Math.abs(startX - points[i][0]); // Same number of steps whether left or right
            int horizontal = Math.abs(startY - points[i][1]); // Same number of steps whether up or down

            // new points to compare to next points in order
            startX = points[i][0];
            startY = points[i][1];

            time += Math.max(vertical, horizontal); // adding diagonal/vertical or horizontal moves
        }

        return time;
    }
}
