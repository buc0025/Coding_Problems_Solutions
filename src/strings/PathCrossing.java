package strings;
/*
https://leetcode.com/problems/path-crossing/
Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west,
respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited.
Return false otherwise.
 */

public class PathCrossing {

    /*
    When drawing out different paths, I noticed that if the opposite directions appear the same number of times as each other and
    if perpendicular directions appear more than once then they will cross paths. This didn't workout because I didn't account for
    opposite directions occurring right next to each other which also crosses paths. I changed the solution but still could not
    pass all of the test cases.

    Top solution uses a set for the x and y coordinates. It starts off as (0,0). X and Y are incremented or decremented when they
    appear in the string. If the set ever sees the same coordinates again then the paths have crossed.
     */

    public boolean isPathCrossing(String path) {
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;

        boolean cross = false;

        if (path.charAt(0) == 'N') {
            n++;
        } else if (path.charAt(0) == 'S') {
            s++;
        } else if (path.charAt(0) == 'E') {
            e++;
        } else {
            w++;
        }

        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                if (path.charAt(i - 1) == 'S') {
                    cross = true;
                }
                n++;
            } else if (c == 'S') {
                if (path.charAt(i - 1) == 'N') {
                    cross = true;
                }
                s++;
            } else if (c == 'E') {
                if (path.charAt(i - 1) == 'W') {
                    cross = true;
                }
                e++;
            } else {
                if (path.charAt(i - 1) == 'E') {
                    cross = true;
                }
                w++;
            }
        }

        if (n == s) {
            if (e == w || e > 0 && w > 0) {
                cross = true;
            }
        } else if (e == w) {
            if (n == s || n > 0 && s > 0) {
                cross = true;
            }
        }

        return cross;
    }
}
