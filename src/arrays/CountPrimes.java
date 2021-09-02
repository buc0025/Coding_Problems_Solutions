package arrays;
/*
https://leetcode.com/problems/count-primes/
Count the number of prime numbers less than a non-negative number, n.
 */

import java.util.HashSet;
import java.util.Set;

public class CountPrimes {

    /* Exceeds time limit but guarantees only prime numbers are counted.
    Finding out if a number is prime is to check whether it is evenly divisible by any prime number between 2 and square root
    of the number
    */
    public int countPrimes(int n) {
        int result = 0;

        for (int i = 2; i < n; i++) {
            boolean prime = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                result++;
            }
        }

        return result;
    }

    // Incorrect solution. Output is more than actual prime numbers. Thought was if number is not divisible by 2,3,5, and 7, then
    // the number is prime.
    public int countPrimes(int n) {
        int result = 0;
        Set<Integer> primes = new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);

        for (int i = 2; i < n; i++) {
            if (primes.contains(i)) {
                result++;
            }
            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                result++;
            }
        }

        return result;
    }
}
