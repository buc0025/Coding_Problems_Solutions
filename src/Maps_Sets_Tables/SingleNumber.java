package Maps_Sets_Tables;
import java.util.*;

/*
https://leetcode.com/problems/single-number/
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */

public class SingleNumber {

    public int singleNumber1(int[] nums) {
        int target = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n,2);
            } else {
                map.put(n,1);
            }
        }

        for (int m : map.keySet()) {
            if (map.get(m) == 1) {
                target = m;
            }
        }
        return target;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        for (int n : set) {
            return n;
        }
        return -1;
    }
}
