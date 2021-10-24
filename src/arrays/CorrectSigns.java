package arrays;
/*
https://edabit.com/challenge/vtW558tXEYFQGv27S

Create a function that returns true if a given inequality expression is correct and false otherwise.
 */

public class CorrectSigns {

    public static boolean correctSigns(String str) {
        String[] arr = str.split(" ");
        boolean equal = true;

        for (int i = 0; i < arr.length - 2; i+=2) {
            int left = Integer.parseInt(arr[i]);
            int right = Integer.parseInt(arr[i + 2]);

            if (arr[i + 1].equals("<")) {
                if (left >= right) {
                    return false;
                }
            } else {
                if (left <= right) {
                    return false;
                }
            }
        }

        return true;
    }
}
