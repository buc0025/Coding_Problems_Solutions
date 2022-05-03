package Maps_Sets_Tables;
/*
https://edabit.com/challenge/NkatKxjHtPed4J3EF

What do the digits 0, 4, 6, 8, and 9 have in common? Well, they are whole numbers... and they are also hole numbers (not actually
a thing until now). Hole numbers are numbers with holes in their shapes (8 is special in that it contains two holes).

14 is a hole number with one hole. 88 is a hole number with four holes.

Your task is to create a function with argument N that returns the sum of the holes for the integers n in the range of range
0 < n <= N.

To illustrate, sumOfHoles(14) returns 7, because there are 7 holes in 4, 6, 8, 9, 10 and 14.
 */

public class SumOfHoles {

    // 5/2/2022 solution
    public static int sumOfHoles(int N) {
        int holes = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(4, 1);
        map.put(6, 1);
        map.put(8, 2);
        map.put(9, 1);
        map.put(0, 1);

        for (int i = 1; i <= N; i++) {
            int j = i;
            while (j > 0) {
                int num = j % 10;
                if (map.containsKey(num)) {
                    holes += map.get(num);
                }
                j /= 10;
            }
        }

        return holes;
    }
}
