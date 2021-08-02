package arrays;
/*
https://leetcode.com/problems/moving-stones-until-consecutive/
Three stones are on a number line at positions a, b, and c.

Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone), and move it to an unoccupied
position between those endpoints.  Formally, let's say the stones are currently at positions x, y, z with x < y < z.  You pick up
the stone at either position x or position z, and move that stone to an integer position k, with x < k < z and k != y.

The game ends when you cannot make any more moves, ie. the stones are in consecutive positions.

When the game ends, what is the minimum and maximum number of moves that you could have made?  Return the answer as an length 2
array: answer = [minimum_moves, maximum_moves]
 */

public class NumMovesStones {

    // Find the order of the 3 ints and the max moves will be max - min - 1
    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = 0;

        if (a != max && a != min) {
            mid = a;
        } else if (b != max && b != min) {
            mid = b;
        } else {
            mid = c;
        }

        int maxMoves = max - min - 1;

        if (maxMoves == 1) {
            return new int[] {0,0};
        }

        if (mid - min > 2 && max - mid > 2) {
            return new int[] {2, maxMoves - 1};
        }

        return new int[] {1, maxMoves - 1};
    }
}
