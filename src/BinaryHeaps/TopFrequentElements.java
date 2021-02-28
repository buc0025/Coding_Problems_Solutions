package BinaryHeaps;
/*
https://leetcode.com/problems/top-k-frequent-elements/
Given a non-empty array of integers, return the k most frequent elements.
 */

public class TopFrequentElements {

    // Incorrect solution. Solution only works if number of occurrences in array is unique
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Keeps track of each element's occurrence
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        Set<Integer> set = new HashSet<>();

        // Helps sort the order of occurrences
        for (int n : map.values()) {
            set.add(n);
        }

        List<Integer> list = new ArrayList<>();

        // Using a list to hold values in set since indexes can't be
        // accessed in set
        for (int s : set) {
            list.add(s);
        }

        int[] ans = new int[k];
        int ansIndex = 0;

        // Adding element that matches the number of occurrences at the
        // end of the list
        for (int n : map.keySet()) {
            int size = list.size();
            if (ansIndex < k) {
                if (list.get(size - 1) == map.get(n)) {
                    ans[ansIndex] = n;
                    ansIndex++;
                    list.remove(size - 1);
                }
            }
        }

        return ans;
    }

    //Incorrect attempt. Was under the assumption that top k frequent elements were unique and therefore used a set
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        // Maps the number of occurrences as values
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int n : nums) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }

        // Maps the number of occurrences as keys
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int m : map1.keySet()) {
            map2.put(map1.get(m), m);
        }

        // Set sorts and holds the number of occurrences of elements
        Set<Integer> set = new HashSet<>();

        for (int m : map2.keySet()) {
            set.add(m);
        }

        List<Integer> list = new ArrayList<>();

        for (int s : set) {
            list.add(s);
        }

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            int num = list.get(list.size()-1);
            arr[i] = map2.get(num);
            list.remove(list.size()-1);
        }

        return arr;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)-> (map.get(b) - map.get(a)));

        for (int m : map.keySet()) {
            maxHeap.add(m);
        }

        for (int i = 0; i < k; i++) {
            arr[i] = maxHeap.poll();
        }

        return arr;
    }
}
