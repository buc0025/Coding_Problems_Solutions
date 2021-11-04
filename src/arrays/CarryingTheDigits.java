package arrays;
/*
https://edabit.com/challenge/5snfPLPbvjAsZ5kjo

Write a function that returns the number of times you must carry a digit when you sum together two integers.
 */

public class CarryingTheDigits {

    public static int carryDigits(int n1, int n2) {
        int result = 0;
        int carry = 0;

        while (n1 > 0 && n2 > 0) {
            int digit1 = n1 % 10;
            int digit2 = n2 % 10;
            if ((digit1 + digit2 + carry > 9)) {
                result++;
                carry = 1;
            } else {
                carry = 0;
            }

            n1 /= 10;
            n2 /= 10;
        }

        return result;
    }
}
