package arrays;
/*
https://edabit.com/challenge/drRFWCuz8jWAPmFRj

Write a function that returns true if two arrays, when combined, form a consecutive sequence. A consecutive sequence is a sequence
without any gaps in the integers, e.g. 1, 2, 3, 4, 5 is a consecutive sequence, but 1, 2, 4, 5 is not.
 */

public class ConsecutiveCombo {

    // 4/24/2022 solution
    public static boolean consecutiveCombo(int[] r,int[] s) {
        int index = 0;
        int[] arr = new int[r.length + s.length];

        for (int i = 0; i < r.length; i++) {
            arr[index] = r[i];
            index++;
        }

        for (int i = 0; i < s.length; i++) {
            arr[index] = s[i];
            index++;
        }

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - 1 != arr[i - 1]) {
                return false;
            }
        }
        
        return true;
    }
}
