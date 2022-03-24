package arrays;
/*
https://leetcode.com/problems/richest-customer-wealth/

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank.
Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the
maximum wealth.
 */

public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        int richest = 0;

        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            richest = Math.max(richest, sum);
            sum = 0;
        }

        return richest;
    }
}
