package arrays;
/*
https://edabit.com/challenge/Tyzp6S67dtXPAAQan

A Primorial is a product of the first n prime numbers (e.g. 2 x 3 x 5 = 30). 2, 3, 5, 7, 11, 13 are prime numbers. If n was 3,
you'd multiply 2 x 3 x 5 = 30 or Primorial = 30.

Create a function that returns the Primorial of a number.
 */

public class FindPrimorial {

    public static int primorial(int n) {
        int result = 1;
        int[] primes = new int[n];

        int index = 0;

        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (i == 2 || i == 3 || i == 5 || i == 7) {
                primes[index] = i;
                index++;
            } else if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                primes[index] = i;
                index++;
            }

            if (index == n) {
                break;
            }
        }

        for (int prime : primes) {
            result *= prime;
        }

        return result;
    }
}
