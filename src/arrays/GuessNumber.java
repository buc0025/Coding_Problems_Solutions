package arrays;
/*
https://leetcode.com/problems/guess-number-higher-or-lower/

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.
 */

public class GuessNumber {

    // 5/27/2022 solution
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int half = left + (right - left) / 2;
            if (guess(half) == 0) {
                return half;
            }
            if (guess(half) == -1) {
                right = half - 1;
            } else {
                left = half + 1;
            }
        }

        return n;
    }
}
