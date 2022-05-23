package strings;
/*
https://edabit.com/challenge/BdLPEtbChBG6nvYT6

A logarithm is kind of like reverse exponents. There is a base and a number in a logarithm. The point of a logarithm is to find
out what power you have to raise for the base to get the number next to the base.
 */

public class Logarithm {

    // 5/22/2022 solution
    public static Object logarithm(Object base, Object num) {
        int base1 = Integer.parseInt(base.toString());
        int num1 = Integer.parseInt(num.toString());

        if (base1 > num1) {
            return "Invalid";
        }

        int result = 1;
        int newBase = base1;

        for (int i = 0; i < num1 / 2; i++) {
            if (newBase * base1 == num1) {
                return ++result;
            }
            newBase *= base1;
            result++;
        }

        return "Invalid";
    }
}
