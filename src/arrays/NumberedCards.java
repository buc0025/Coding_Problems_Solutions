package arrays;
/*
https://edabit.com/challenge/qE9gCJtrtcMurvQtT

You have a pack of 5 randomly numbered cards, which can range from 0-9. You can win if you can produce a higher two-digit number
from your cards than your opponent. Return true if your cards win that round.
 */



public class NumberedCards {

    // Solution with using built in sort
    public static boolean winRound(int[] you, int[] opp) {
        int you1 = 0;
        int you2 = 0;
        int opp1 = 0;
        int opp2 = 0;

        int youIndex = -1;
        int oppIndex = -1;

        for (int i = 0; i < 5; i++) {
            if (you[i] >= you1 && youIndex != i) {
                you1 = you[i];
                youIndex = i;
            }
            if (opp[i] >= opp1 && oppIndex != i) {
                opp1 = opp[i];
                oppIndex = i;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (you[i] >= you2 && youIndex != i) {
                you2 = you[i];
            }
            if (opp[i] >= opp2 && oppIndex != i) {
                opp2 = opp[i];
            }
        }

        int yourCards = you1 * 10 + you2;
        int oppCards = opp1 * 10 + opp2;

        return yourCards > oppCards;
    }

    public static boolean winRound(int[] you, int[] opp) {
        Arrays.sort(you);
        Arrays.sort(opp);

        int yourCards = you[4] * 10 + you[3];
        int oppCards = opp[4] * 10 + opp[3];

        return yourCards > oppCards;
    }
}
