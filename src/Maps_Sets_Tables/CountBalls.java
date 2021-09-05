package Maps_Sets_Tables;
/*
https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
You are working in a ball factory where you have n balls numbered from lowLimit up to highLimit inclusive (i.e., n == highLimit -
lowLimit + 1), and an infinite number of boxes numbered from 1 to infinity.

Your job at this factory is to put each ball in the box with a number equal to the sum of digits of the ball's number. For
example, the ball number 321 will be put in the box number 3 + 2 + 1 = 6 and the ball number 10 will be put in the box number
1 + 0 = 1.

Given two integers lowLimit and highLimit, return the number of balls in the box with the most balls.
 */

public class CountBalls {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = lowLimit; i <= highLimit; i++) {
            int n = i;
            int num = 0;

            while (n > 0) {
                num += n % 10;
                n /= 10;
            }

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int max = 0;

        for (int m : map.keySet()) {
            if (map.get(m) >= max) {
                max = map.get(m);
            }
        }

        return max;
    }
}
