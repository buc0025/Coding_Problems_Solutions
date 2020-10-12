package Maps_Sets_Tables;
/*
https://leetcode.com/problems/reduce-array-size-to-the-half/
Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.
 */

public class ReduceArray {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // Assigning elements in array as keys and occurrences as values
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        int[] numOfOccurrence = new int[map.size()];
        int index = 0;

        // Populating array with values (occurrences) in map
        for (int a : map.values()) {
            numOfOccurrence[index] = a;
            index++;
        }

        Arrays.sort(numOfOccurrence);

        int count = 0;
        int arrayIndex = numOfOccurrence.length-1; // Starting at end of sorted array to get max value
        int arrLen = arr.length;

        while (arrLen > arr.length / 2) {
            arrLen = arrLen - numOfOccurrence[arrayIndex];
            arrayIndex--;
            count++;
        }
        return count;
    }
}
