package arrays;
/*
https://edabit.com/challenge/L5uwyF4SsAG4DmPpJ

Given a list of directions to spin, "left" or "right", return an integer of how many full 360° rotations were made. Note that each
word in the array counts as a 90° rotation in that direction.
 */

public class SpinAround {

    public static int spinAround(String[] turns) {
        int right = 0;
        int left = 0;
        int rotation = 0;

        for (int i = 0; i < turns.length; i++) {
            if (turns[i].equals("right")) {
                right++;
                left--;
            } else {
                left++;
                right--;
            }

            if (right >= 4 && right % 4 == 0) {
                rotation++;
            }

            if (left >= 4 && left % 4 == 0) {
                rotation++;
            }
        }

        return rotation;
    }
}
