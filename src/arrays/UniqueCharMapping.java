package arrays;
/*
https://edabit.com/challenge/zcobRojF5p8DWkfiC

Write a function that returns a character mapping from a word.
 */

public class UniqueCharMapping {

    public static int[] characterMapping(String str) {
        int[] arr = new int[str.length()];
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, count);
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            char c = str.charAt(i);
            arr[i] = map.get(c);
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }

        return arr;
    }
}
