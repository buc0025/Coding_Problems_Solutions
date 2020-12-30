package Maps_Sets_Tables;
/*
https://leetcode.com/problems/sort-integers-by-the-power-value/
The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:
if x is even then x = x / 2
if x is odd then x = 3 * x + 1
For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).

Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending
order, if two or more integers have the same power value sort them by ascending order.

Return the k-th integer in the range [lo, hi] sorted by the power value.

Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power
of x is will fit in 32 bit signed integer.
 */

public class SortByPowerValue {

    // Incorrect attempt, solution calls for a heap
    public int getKth(int lo, int hi, int k) {
        // Map range from lo to hi as keys and power of the integer as values
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = lo; i <= hi; i++) {
            int steps = 0;
            int num = i;
            while (num > 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = 3 * num + 1;
                }
                steps++;
            }
            map.put(i, steps);
        }

        List<Integer> list = new ArrayList<>();

        for (int m : map.values()) {
            list.add(m);
        }

        // Sorts values in map in ascending order
        Collections.sort(list);

        int number = list.get(k - 1);
        int answer = -1;

        for (int m : map.keySet()) {
            if (map.get(m) == number) {
                answer = m;
            }
        }
        return answer;
    }
}
