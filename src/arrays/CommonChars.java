package arrays;
/*
https://leetcode.com/problems/find-common-characters/
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings
within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times,
you need to include that character three times in the final answer.

You may return the answer in any order.
 */

public class CommonChars {
****** Incorrect Attempt at random mock interview question*******
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();

        // Using the first element in array to compare the rest of the elements
        for (int i = 0; i < A[0].length(); i++) {
            list.add(A[0].substring(i, i + 1));
        }

        // Comparing every char at each String index
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                // Initial thought was to remove any char that was in my original String list
                // but that didn't work since the list will not change.
                if (!list.contains(A[i].substring(j, j + 1))) {
                    list.remove(A[i].substring(j, j + 1));
                }
            }
        }

        return list;
    }
}
