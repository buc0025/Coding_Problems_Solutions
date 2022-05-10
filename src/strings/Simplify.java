package strings;
/*
https://edabit.com/challenge/bmwpoeCybNWnBxn7M

Create a function that returns the simplified version of a fraction.
 */

public class Simplify {

    // 5/9/2022 unfinished solution
    public static String simplify(String str) {
        int separate = str.indexOf("/");
        int numerator = Integer.parseInt(str.substring(0, separate));
        int denominator = Integer.parseInt(str.substring(separate + 1));
        int commonFactor = 1;

        int min = Math.min(numerator, denominator);
        for (int i = 1; i <= min; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                commonFactor = i;
            }
        }

        if (commonFactor == 1) {
            System.out.println(str);
        }

        if (numerator == denominator) {
            System.out.println("1");
        }

        if (numerator > denominator && commonFactor == denominator) {
            int ans = numerator / denominator;
            System.out.println(ans + "");
        }
    }
}
