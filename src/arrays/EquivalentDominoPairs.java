package arrays;
/*
https://leetcode.com/problems/number-of-equivalent-domino-pairs/
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or
(a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 */

public class EquivalentDominoPairs {

    // Brute force solution comparing current element array with every following element
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;

        for (int i = 0; i < dominoes.length; i++) {
            int first = dominoes[i][0];
            int second = dominoes[i][1];
            for (int j = i + 1; j < dominoes.length; j++) {
                if (dominoes[j][0] == first && dominoes[j][1] == second) {
                    count++;
                } else if (dominoes[j][0] == second && dominoes[j][1] == first) {
                    count++;
                }
            }
        }

        return count;
    }
}
