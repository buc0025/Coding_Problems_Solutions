package arrays;
/*
https://leetcode.com/problems/lemonade-change/
At a lemonade stand, each lemonade costs $5.

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each
customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return true if and only if you can provide every customer with correct change.
 */

public class LemonadeChange {

    // 8/25/2022 solution
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }

        int fives = 1;
        int tens = 0;

        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 5) {
                fives++;
            }
            if (bills[i] == 10) {
                if (fives == 0) {
                    return false;
                } else {
                    tens++;
                    fives--;
                }
            }
            if (bills[i] == 20) {
                if (fives == 0) {
                    return false;
                } else if (tens == 0 && fives < 3) {
                    return false;
                } else if (tens >= 1) {
                    fives--;
                    tens--;
                } else {
                    fives-=3;
                }
            }
        }

        return true;
    }

    /*
    Initially thought of using a map to hold the denominations for $5, $10, $20 and their occurrences. An array made more sense since
    we're only keeping track of 3 different denominations. The only denominations that might return false are $10 and $20. We have
    to have at least one $5 bill for every $10. For every $20 we receive, we must have either one $5 and one $10 or three $5 bills.
     */
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                change[0]++;
            } else if (bills[i] == 10) {
                change[1]++;
                if (change[0] > 0) {
                    change[0]--;
                } else {
                    return false;
                }
            } else {
                if (change[0] > 0 && change[1] > 0) {
                    change[0]--;
                    change[1]--;
                } else if (change[0] >= 3 && change[1] == 0) {
                    change[0]-=3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
