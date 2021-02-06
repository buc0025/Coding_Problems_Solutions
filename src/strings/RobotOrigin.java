package strings;
/*
https://leetcode.com/problems/robot-return-to-origin/
There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends
up at (0, 0) after it completes its moves.

The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L
(left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise,
return false.

Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always
make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 */

public class RobotOrigin {

    public boolean judgeCircle(String moves) {
        int right = 0;
        int down = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                right++;
            } else if (moves.charAt(i) == 'L') {
                right--;
            } else if (moves.charAt(i) == 'D') {
                down++;
            } else {
                down--;
            }
        }

        if (right == 0 && down == 0) {
            return true;
        }

        return false;
    }
}
