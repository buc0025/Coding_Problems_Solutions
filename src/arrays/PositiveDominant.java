package arrays;
/*
https://edabit.com/challenge/zi3zKpBLYHqtmSf5m

An array is positive dominant if it contains strictly more unique positive values than unique negative values. Write a function
that returns true if an array is positive dominant, false, otherwise.
 */

public class PositiveDominant {

    //Incorrect solution. Passes 17/18 test cases
    public static boolean isPositiveDominant(int[] n) {
        Arrays.sort(n);
        int positive = 0;
        int negative = 0;

        if (n[0] != n[1]) {
            if (n[0] > 0) {
                positive++;
            } else if (n[0] < 0) {
                negative++;
            }
        }

        if (n[0] == n[1] && n[0] != 0) {
            if (n[0] > 0) {
                positive++;
            } else if (n[0] < 0) {
                negative++;
            }
        }

        for (int i = 1; i < n.length; i++) {
            if (n[i] != n[i - 1]) {
                if (n[i] > 0) {
                    positive++;
                } else if (n[i] < 0) {
                    negative++;
                }
            }
        }

        return positive > negative;
    }

    public static boolean isPositiveDominant(int[] n) {
        Set<Integer> positive = new HashSet<>();
        Set<Integer> negative = new HashSet<>();

        for (int num : n) {
            if (num < 0) {
                negative.add(num);
            } else if (num > 0){
                positive.add(num);
            }
        }

        return positive.size() > negative.size();
    }
}
