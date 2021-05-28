package strings;
/*
https://leetcode.com/problems/determine-color-of-a-chessboard-square/
You are given coordinates, a string that represents the coordinates of a square of the chessboard.
Return true if the square is white, and false if the square is black.

The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number
second.
 */

public class SquareIsWhite {

    public boolean squareIsWhite(String coordinates) {
        int letter = (int) coordinates.charAt(0);
        int num = Integer.valueOf(coordinates.substring(1));

        if (letter % 2 == 1) {
            if (num % 2 == 1) {
                return false;
            } else {
                return true;
            }
        } else {
            if (num % 2 == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
