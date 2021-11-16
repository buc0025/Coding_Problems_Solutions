package arrays;
/*
https://edabit.com/challenge/zi3zKpBLYHqtmSf5m

An array is positive dominant if it contains strictly more unique positive values than unique negative values. Write a function
that returns true if an array is positive dominant, false, otherwise.
 */

public class PositiveDominant {

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
