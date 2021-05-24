package arrays;
/*
https://leetcode.com/problems/minimum-index-sum-of-two-lists/
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers,
output all of them with no order requirement. You could assume there always exists an answer.
 */

public class FindRestaurant {

    /*
    Leetcode solution only uses one hashmap to hold the restaurants and indices from the first array. A list is used for any
    restaurants in the second that appear in the hashmap. Variables min_sum and sum are used to determine which restaurants should
    be added to the final array.
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        // The maximum common restaurant is at most the size of the smaller string array.
        // The set is used to hold the common restaurants between the two arrays.
        if (list1.length < list2.length) {
            for (String list : list1) {
                set.add(list);
            }

            for (String list : list2) {
                if (set.contains(list)) {
                    map.put(list, 0);
                }
            }
        } else {
            for (String list : list2) {
                set.add(list);
            }

            for (String list : list1) {
                if (set.contains(list)) {
                    map.put(list, 0);
                }
            }
        }

        // The map contains common restaurants as keys and sum of indices as values
        for (int i = 0; i < list1.length; i++) {
            if (map.containsKey(list1[i])) {
                map.put(list1[i], map.get(list1[i]) + i);
            }
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                map.put(list2[i], map.get(list2[i]) + i);
            }
        }

        int min = Integer.MAX_VALUE;

        // Looking for the least list index sum.
        for (int m : map.values()) {
            if (m <= min) {
                min = m;
            }
        }

        int arrSize = 0;

        // Looking for how many times least list index sum appears and that will determine size of array to be returned
        for (int m : map.values()) {
            if (m == min) {
                arrSize++;
            }
        }

        String[] arr = new String[arrSize];
        int index = 0;

        for (String m : map.keySet()) {
            if (map.get(m) == min) {
                arr[index] = m;
                index++;
            }
        }

        return arr;
    }

    /*
    Incorrect solution because I thought I was only looking for one common restaurant that had the least list index sum. Set2 was
    to keep track of common interest restaurants. The idea was to get the minimum index between min1 and min2 and then search for
    it in one of the arrays.
     */
    Set<String> set = new HashSet<>();
    Set<String> set2 = new HashSet<>();

        if (list1.length < list2.length) {
        for (String list : list1) {
            set.add(list);
        }

        for (String list : list2) {
            if (set.contains(list)) {
                set2.add(list);
            }
        }
    } else {
        for (String list : list2) {
            set.add(list);
        }

        for (String list : list2) {
            if (set.contains(list)) {
                set2.add(list);
            }
        }
    }

    int min1 = 0;
    int min2 = 0;

        for (int i = 0; i < list1.length; i++) {
        if (set2.contains(list1[i])) {
            min1 = i;
            break;
        }
    }

        for (int i = 0; i < list2.length; i++) {
        if (set2.contains(list2[i])) {
            min2 = i;
            break;
        }
    }
}
