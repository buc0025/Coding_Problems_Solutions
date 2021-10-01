package arrays;
/*
https://edabit.com/challenge/CKqfEowjmSTw2jsso

Create a function that takes an array of numbers and return "Boom!" if the digit 7 appears in the array. Otherwise, return
"there is no 7 in the array".
 */

public class SevenBoom {

    public static String sevenBoom(int[] arr) {
        boolean seven = false;

        for (int a : arr) {
            int n = a;

            while (n > 0) {
                if (n % 10 == 7) {
                    seven = true;
                    break;
                }
                n /= 10;
            }

            if (seven) {
                return "Boom!";
            }
        }

        return "there is no 7 in the array";
    }
}
