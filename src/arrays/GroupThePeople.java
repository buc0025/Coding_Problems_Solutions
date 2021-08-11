package arrays;
/*
https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.

You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if
groupSizes[1] = 3, then person 1 must be in a group of size 3.

Return a list of groups such that each person i is in a group of size groupSizes[i].

Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of
them. It is guaranteed that there will be at least one valid solution for the given input.
 */

public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // keeps track of number of groups that belong to certain group size

        for (int g : groupSizes) {
            map.put(g, map.getOrDefault(g, 0) + 1);
        }

        for (int m : map.keySet()) {
            int index = 0; // Tracks index of given array
            int size = 0; // Tracks the number of groups in m
            int groups = map.get(m) / m;
            while (size < groups) {
                List<Integer> list = new ArrayList<>();
                int size1 = 0; // Keeps track of how many elements in list
                for (int i = index; i < groupSizes.length; i++) {
                    if (groupSizes[i] == m && size1 < m) {
                        list.add(i);
                        size1++;
                    } else if (groupSizes[i] == m && size1 == m) { /*if elements exceed group size we need to create new list to
                    hold additional elements while keeping track of which index I left off at.
                    */
                        index = i;
                        break;
                    }
                }
                size++;
                result.add(list);
            }
        }

        return result;
        //8/11/2021 test
    }
}
