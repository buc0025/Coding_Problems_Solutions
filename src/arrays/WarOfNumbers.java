package arrays;
/*
https://edabit.com/challenge/7fHsizQrTLXsPWMyH

There's a great war between the even and odd numbers. Many numbers already lost their life in this war and it's your task to end
this. You have to determine which group sums larger: the even, or the odd. The larger group wins.

Create a function that takes an array of integers, sums the even and odd numbers separately, then returns the difference between
sum of even and odd numbers.
 */

public class WarOfNumbers {

    public static int warOfNumbers(int[]numbers){
        int even = 0;
        int odd = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                even += numbers[i];
            } else {
                odd += numbers[i];
            }
        }

        return Math.abs(even - odd);
    }
}
