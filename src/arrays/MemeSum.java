package arrays;
/*
https://edabit.com/challenge/4HRk9MkZm4wNR6PZJ

For this challenge, forget how to add two numbers together.

26 + 39 = 515
122 + 81 = 1103
1222 + 30277 = 31499
 */

public class MemeSum {

    public static int memeSum(int a, int b) {
        StringBuilder number = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        while (a > 0 || b > 0) {
            int sum = 0;
            if (a > 0 && b > 0) {
                sum += a % 10 + b % 10;
            } else if (a > 0) {
                sum += a % 10;
            } else {
                sum += b % 10;
            }

            number.append(sum);
            number.append(" ");
            a /= 10;
            b /= 10;
        }

        for (int i = number.length() - 1; i >= 0; i--) {
            if (i > 0) {
                if (number.charAt(i - 1) == ' ') {
                    reverse.append(number.charAt(i));
                } else {
                    reverse.append(number.charAt(i - 1));
                    reverse.append(number.charAt(i));
                    i--;
                }
            } else {
                reverse.append(number.charAt(i));
            }
        }

        return reverse;
    }

}
