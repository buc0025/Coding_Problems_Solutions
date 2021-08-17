package arrays;
/*
Question for coding assessment on 06/24/2021
Majority element of an array is defined as a value x for which strictly more than half of array elements are equal to x. Output
the majority element of the given array, or -1 if the array doesn't have majority element.
 */

public class MajorityElement {

    //Different solution without having to use a map
    public int majorityElement(String lengthOfArray, String numsInArray) {
            int len = Integer.parseInt(lengthOfArray);
            int half = 0;
            int result = -1;

            if (len % 2 == 0) {
                half = len / 2;
            } else {
                half = len / 2 + 1;
            }

            int[] nums = new int[101];

            for (int i = 0; i < numsInArray.length(); i++) {
                if (numsInArray.charAt(i) != ' ') {
                    int val = Integer.parseInt(numsInArray.substring(i, i + 1));
                    nums[val]++;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= half) {
                    result = i;
                    break;
                }
            }

            System.out.println(result);
    }

    public int majorityElement(String lengthOfArray, String numsInArray) {
        String[] arr1 = numsInArray.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int len = Integer.valueOf(lengthOfArray);
        int count = 0;
        int ans = -1;
        int half = 0;

        if (len % 2 == 0) {
            half = half / 2;
        } else {
            half = len / 2 + 1;
        }

        for (String a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (String val : map.keySet()) {
            if (map.get(val) >= count) {
                count = Math.max(map.get(val), count);
                ans = Integer.valueOf(val);
            }
        }

        if (count >= half) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

    }
}
