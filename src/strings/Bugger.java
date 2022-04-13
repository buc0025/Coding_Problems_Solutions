package strings;
/*
https://edabit.com/challenge/zZxPQRjn8q2iB9Biv

Create a function that takes a number and returns its multiplicative persistence, which is the number of times you must multiply
the digits in num until you reach a single digit.
 */

public class Bugger {

    // 4/12/2022 solution
    public static int bugger(int num) {
        int count = 0;

        while (num >= 10) {
            String number = String.valueOf(num);
            int multiply = 1;

            for (int i = 0; i < number.length(); i++) {
                multiply *= (Integer.valueOf(number.substring(i, i + 1)));
            }
            count++;
            num = multiply;
        }

        return count;
    }
}
