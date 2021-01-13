package arrays;
/*
https://leetcode.com/problems/self-dividing-numbers/
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 */

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int num = i;
            int n = i;
            int space = 0;
            // Find the number of digits in number
            while (n > 0) {
                n /= 10;
                space++;
            }

            while (num > 0) {
                int end = num % 10; // Represents the right most digit of num
                if (end == 0) {
                    break;
                }
                // Decrement the number of digits in i if i is divisible by digit
                if (i % end == 0) {
                    space--;
                }
                if (space == 0) {
                    list.add(i);
                }
                num /= 10;
            }
        }
        
        return list;
    }
}
