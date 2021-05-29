package arrays;
/*
https://leetcode.com/problems/maximum-units-on-a-truck/
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] =
[numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any
boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.
 */

public class MaximumUnits {

    /*
    The constraint for number of units per box is 1000. In order to maximum the number of units, we target the boxes with the largest
    units first and load them onto the truck before moving to the next boxes with smaller units. A new array was created to represent
    the numbers of possible units and the elements inside would represent the number of boxes containing those units. I then worked
    backwards filling the truck with the boxes with the largest units to the ones with less until the truck filled.
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] arr = new int[1001];
        int ans = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            arr[boxTypes[i][1]] += boxTypes[i][0];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int size = arr[i];
            while (size > 0) {
                truckSize--;
                size--;
                ans += i;
                if (truckSize == 0) {
                    break;
                }
            }
            if (truckSize == 0) {
                break;
            }
        }

        return ans;
    }
}
