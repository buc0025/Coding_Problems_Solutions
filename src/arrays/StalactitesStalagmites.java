package arrays;
/*
https://edabit.com/challenge/v96NThCRg5M5MLGfq

Stalactites hang from the ceiling of a cave while stalagmites grow from the floor.

Create a function that determines whether the input represents "stalactites" or "stalagmites". If it represents both, return
"both". Input will be a 2D array, with 1 representing a piece of rock, and 0 representing air space.
 */

public class StalactitesStalagmites {

    public static String mineralFormation(int[][] form) {
        int len = form.length - 1;
        int top = 0;
        int bottom = 0;

        for (int i = 0; i < form[0].length; i++) {
            if (form[0][i] == 1) {
                top++;
            }
        }

        for (int i = 0; i < form[len].length; i++) {
            if (form[len][i] == 1) {
                bottom++;
            }
        }

        if (top > 0 && bottom > 0) {
            return "both";
        }

        return top > 0 ? "stalactites" : "stalagmites";
    }
}
