package arrays;
/*
https://leetcode.com/problems/duplicate-zeros/
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.
 */

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if (arr[i] == 0) {
                list.add(0);
            }
            if (list.size() == arr.length) {
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}
