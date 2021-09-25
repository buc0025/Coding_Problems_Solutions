package arrays;
/*
https://edabit.com/challenge/a5onNYqzuKiGjWMQu

Write a function that returns the smallest N-digit number which is a multiple of the specified value.
 */

public class SmallestNDigit {

    public static int smallest(int digits, int value) {
        int placeVal = 1;
        int times = 1;
        int result = 0;

        while (placeVal < digits) {
            result = value * times++;

            String num = String.valueOf(result);

            placeVal = num.length();
        }

        return result;
    }
}
