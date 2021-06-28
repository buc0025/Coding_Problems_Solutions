package arrays;
/*
https://leetcode.com/problems/positions-of-large-groups/
In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group.
In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.
 */

public class LargeGroupPositions {

    /*
    The idea is to find if a group is larger than 2 and go into another loop that sees how big that group is. Once we find the end
    of the large group, i is assigned to where the last index of the large group left off which will still be o(n) time complexity.
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (i + 2 < s.length() && s.charAt(i + 1) == a && s.charAt(i + 2) == a) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != a) {
                        list.add(j - 1);
                        ans.add(list);
                        i = j - 1;
                        break;
                    }
                    if (j == s.length() - 1) {
                        list.add(j);
                        ans.add(list);
                        i = j;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
