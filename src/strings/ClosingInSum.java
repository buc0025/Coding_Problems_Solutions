package strings;
/*
https://edabit.com/challenge/EhX7SGqPTyxQc4pb2

Create a function that returns the sum of the digits formed from the first and last digits, all the way to the center of the
number.
 */

public class ClosingInSum {

    // 5/14/2022 solution
    public static int closingInSum(long num) {
        String number = String.valueOf(num);
        int left = 0;
        int right = number.length() - 1;
        int sum = 0;

        while (left < right) {
            String ends = number.substring(left, left + 1) + number.substring(right, right + 1);
            sum += Integer.parseInt(ends);
            left++;
            right--;
        }

        if (number.length() % 2 == 1) {
            int half = number.length() / 2;
            String middle = number.substring(half, half + 1);
            sum += Integer.parseInt(middle);
        }

        return sum;
    }
}
