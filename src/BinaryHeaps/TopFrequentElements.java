package BinaryHeaps;
/*
https://leetcode.com/problems/top-k-frequent-elements/
Given a non-empty array of integers, return the k most frequent elements.
 */

public class TopFrequentElements {

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
