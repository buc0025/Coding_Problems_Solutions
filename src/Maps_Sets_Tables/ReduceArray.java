package Maps_Sets_Tables;
/*
https://leetcode.com/problems/reduce-array-size-to-the-half/
Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.
 */

public class ReduceArray {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // New array will hold number of occurrences
        int[] nums = new int[map.size()];
        int index = 0;

        for (int i : map.values()) {
            nums[index] = i;
            index++;
        }

        Arrays.sort(nums);

        int count = 0;
        int len = arr.length;

        // Largest elements will be at end of sorted array, so start at the end
        for (int i = nums.length - 1; i >= 0; i--) {
            len -= nums[i];
            count++;
            if (len <= arr.length / 2) {
                break;
            }
        }

        return count;
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        // Keys are the elements in array and number of occurrences are values
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // Creating an array that only holds the values
        int[] nums = new int[map.size()];

        int index = 0;

        for (int m : map.values()) {
            nums[index] = m;
            index++;
        }

        Arrays.sort(nums);

        int count = 0;
        int halfLength = 0;

        // Biggest number of occurrences will be at the end of the array so we're going to add
        // those elements first to get to at least half the given array length to find the minimum
        for (int i = nums.length - 1; i >= 0; i--) {
            if (halfLength >= arr.length / 2) {
                break;
            }
            halfLength += nums[i];
            count++;
        }

        return count;
    }

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
