package arrays;
/*
https://edabit.com/challenge/4hZ9cHgvkZ94sr2ae

Create a function that takes an array of increasing letters and return the missing letter.
 */

public class MissingLetter {

    public static String missingLetter(String[] arr) {
        int missing = 0;

        for (int i = 1; i < arr.length; i++) {
            int n = (int) arr[i].charAt(0);

            if (n != (int) arr[i - 1].charAt(0) + 1) {
                missing = n - 1;
                break;
            }
        }

        char letter = (char) missing;

        return String.valueOf(letter);
    }
}
