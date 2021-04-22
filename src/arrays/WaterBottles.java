package arrays;
/*
https://leetcode.com/problems/water-bottles/
Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Return the maximum number of water bottles you can drink.
 */

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;

        while (numBottles >= numExchange) {
            int full = numBottles / numExchange;
            total += full;
            numBottles = full + (numBottles % numExchange);
        }

        return total;
    }
}
