package arrays;
/*
https://edabit.com/challenge/EiTYFd9jwghDz3aoG

Create a function that reorders the digits of each numerical element in an array based on ascending (asc) or descending (desc)
order.
 */

public class ReorderDigits {

    public static int[] reorderDigits(int[] arr, String orderBy) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            String sorted = "";
            int[] sort = new int[10];

            while (num > 0) {
                int n = num % 10;
                sort[n]++;
                num /= 10;
            }

            if (orderBy.equals("desc")) {
                for (int j = 9; j >= 0; j--) {
                    while (sort[j] > 0) {
                        sorted += String.valueOf(j);
                        sort[j]--;
                    }
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    while (sort[j] > 0) {
                        sorted += String.valueOf(j);
                        sort[j]--;
                    }
                }
            }

            arr[i] = Integer.parseInt(sorted);
        }
        return arr;
    }
}
