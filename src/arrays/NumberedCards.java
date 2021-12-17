package arrays;
/*
https://edabit.com/challenge/qE9gCJtrtcMurvQtT

You have a pack of 5 randomly numbered cards, which can range from 0-9. You can win if you can produce a higher two-digit number
from your cards than your opponent. Return true if your cards win that round.
 */

public class NumberedCards {

    public static boolean winRound(int[] you, int[] opp) {
        Arrays.sort(you);
        Arrays.sort(opp);

        int yourCards = you[4] * 10 + you[3];
        int oppCards = opp[4] * 10 + opp[3];

        return yourCards > oppCards;
    }
}
