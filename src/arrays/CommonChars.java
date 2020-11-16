package arrays;
/*
https://leetcode.com/problems/find-common-characters/
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings
within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times,
you need to include that character three times in the final answer.

You may return the answer in any order.
 */

public class CommonChars {

    /*Realized why it was an incorrect attempt after not passing certain test cases. Idea was to see  if the number of
    occurrences of a character is greater than the length of the array. I assumed that character would be added to my
    list because it shows up in each string at least once. I realized this wouldn't work if a string didn't contain a
    certain character while another contained multiple occurrences of that number eg ("aaa" "bbb" "ccc")
     */
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        // Assigning every substring as a key and the number of occurrence as value
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                if (map.containsKey(A[i].substring(j, j+1))) {
                    map.put(A[i].substring(j, j+1), map.get(A[i].substring(j, j+1))+1);
                } else {
                    map.put(A[i].substring(j, j+1), 1);
                }
            }
        }

        // If the number of occurrence is more than length of array then it must appear
        // in every string
        for (String m : map.keySet()) {
            if (map.get(m) / A.length > 0) {
                for (int i = 0; i < map.get(m) / A.length; i++) {
                    list.add(m);
                }
            }
        }

        return list;
    }


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
