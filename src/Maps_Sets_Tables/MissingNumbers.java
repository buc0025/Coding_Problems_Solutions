package Maps_Sets_Tables;
/*
https://www.hackerrank.com/challenges/missing-numbers/problem
Numeros the Artist had two lists that were permutations of one another. He was very proud. Unfortunately, while
transporting them from one exhibition to another, some numbers were lost out of the first list. Can you find the missing numbers?

As an example, the array with some numbers missing, arr = [7,2,5,3,5,3]. The original array of numbers brr = [7,2,5,4,6,3,5,3].
 The numbers missing are [4,6].
 */
public class MissingNumbers {
    static int[] missingNumbers(int[] arr, int[] brr) {
        int[] missingNums = new int[brr.length - arr.length];

        Map<Integer, Integer> arrMap = new HashMap<>();
        Map<Integer, Integer> brrMap = new HashMap<>();

        for (int a : arr) {
            if (arrMap.containsKey(a)) {
                arrMap.put(a, arrMap.get(a) + 1);
            } else {
                arrMap.put(a, 1);
            }
        }

        for (int b : brr) {
            if (brrMap.containsKey(b)) {
                brrMap.put(b, brrMap.get(b) + 1);
            } else {
                brrMap.put(b, 1);
            }
        }

        int index = 0;

        for (int b : brrMap.keySet()) {
            // add b to new array if arrMap doesn't contain b
            if (!arrMap.containsKey(b)) {
                missingNums[index] = b;
                index++;
            }
            // add the number of times b appears more in bMap than aMap to new array
            else if (arrMap.get(b) < brrMap.get(b)) {
                int n = brrMap.get(b) - arrMap.get(b);
                for (int i = 0; i < n; i++) {
                    missingNums[index] = b;
                    index++;
                }
            }
        }

        Arrays.sort(missingNums);
        return missingNums;
    }

}
