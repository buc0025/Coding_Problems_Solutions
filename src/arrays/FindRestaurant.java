package arrays;
/*
https://leetcode.com/problems/minimum-index-sum-of-two-lists/
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers,
output all of them with no order requirement. You could assume there always exists an answer.
 */

public class FindRestaurant {

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
