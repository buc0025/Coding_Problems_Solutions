package arrays;
/*
https://edabit.com/challenge/8SHAyg8kdX8y72S3z

Create a function that takes an array and finds the integer which appears an odd number of times.
 */

public class FindOddInt {

    public static int findOdd(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (int num : map.keySet()) {
            if (map.get(num) % 2 == 1) {
                ans = num;
                break;
            }
        }

        return ans;
    }
}
