package arrays;
/*
https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player A always places "X" characters, while the second player B always places "O" characters.
"X" and "O" characters are always placed into empty squares, never on filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark
their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements
to play return "Pending".

You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.
 */

public class TicTacToe {

    /*
    The idea was to assign each block in the 3x3 grid a value from 1-9. Player A and B will hold a set of those numbers that
    corresponds to where they put their mark. The issue is that there are 8 ways to win but I can't match it with the set. For example,
    one way to win would be to mark every block in the top row which are assigned 1,2,3. If player A has a set of 1,2,3,4 I can just
    compared 1,2,3 to 1,2,3,4.
     */
    public String tictactoe(int[][] moves) {
        Map<String, Integer> map = new HashMap<>();

        int index = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(i + "," + j, index++);
            }
        }

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < moves.length; i+=2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                stringBuilder.append(moves[i][j]);
                stringBuilder.append(",");
            }
            setA.add(map.get(stringBuilder.substring(0,3)));
        }

        for (int i = 1; i < moves.length; i+=2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                stringBuilder.append(moves[i][j]);
                stringBuilder.append(",");
            }
            setB.add(map.get(stringBuilder.substring(0,3)));
        }

    }
}
