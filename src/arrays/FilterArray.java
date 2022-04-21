package arrays;
/*
https://edabit.com/challenge/vNszi3mbJA5BhgGFX

Create a function that takes an array of non-negative integers and strings and return a new array without the strings.
 */

public class FilterArray {

    // 4/20/2022 solution
    public static String[] filterArray(String[] str) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (String n : str) {
            try {
                list.add(Integer.parseInt(n));
                set.add(Integer.parseInt(n));
            } catch (Exception e) {
                continue;
            }
        }

        String[] res = new String[set.size()];
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i))) {
                res[index] = String.valueOf(list.get(i));
                index++;
                set.remove(list.get(i));
            }
        }

        return res;
    }
}
