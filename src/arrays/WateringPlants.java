package arrays;
/*
https://leetcode.com/problems/watering-plants/

You want to water n plants in your garden with a watering can. The plants are arranged in a row and are labeled from 0 to n - 1
from left to right where the ith plant is located at x = i. There is a river at x = -1 that you can refill your watering can at.

Each plant needs a specific amount of water. You will water the plants in the following way:

Water the plants in order from left to right.
After watering the current plant, if you do not have enough water to completely water the next plant, return to the river to fully
refill the watering can.
You cannot refill the watering can early.
You are initially at the river (i.e., x = -1). It takes one step to move one unit on the x-axis.

Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith plant needs, and an integer
capacity representing the watering can capacity, return the number of steps needed to water all the plants.
 */

public class WateringPlants {

    public int wateringPlants(int[] plants, int capacity) {
        int lastPlant = plants.length;
        int totalSteps = 0;
        int plant = 0;
        int currentPlant = 0;

        while (plant < lastPlant) {
            if (plants[currentPlant] < capacity) {
                totalSteps++;
                currentPlant++;
            }
            if (plants[currentPlant] > capacity) {
                totalSteps += currentPlant; // walk back to river
                totalSteps += (currentPlant + 1); // walk back to current plant
            }

        }
    }
}
