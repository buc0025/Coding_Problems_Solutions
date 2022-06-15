package arrays;
/*
https://edabit.com/challenge/THuuakBitThtL6rmq

Write a function that returns the items from an array (given as parameter r) on odd or even positions, depending on it's specifier
(given as parameters) as being the parity. The final array will contain "odd" items on odd positions (1, 3, 5, ...) and "even" for
items on even positions (2, 4, 6, ...).
 */

public class CharAtPos {

    // 6/14/2022 solution
    public static Object[] charAtPos(Object[] arr, String par) {
        List<Object> reverse = new ArrayList<>();

        if (par.equals("even")) {
            for (int i = arr.length - 2; i >= 0; i-=2) {
                reverse.add(arr[i]);
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i-=2) {
                reverse.add(arr[i]);
            }
        }

        Object[] ans = new Object[reverse.size()];
        int index = reverse.size() - 1;

        for (int i = 0; i < ans.length; i++) {
            ans[i] = reverse.get(index);
            index--;
        }

        return ans;
    }
}
