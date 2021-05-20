package arrays;
/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many
times as it shows in both arrays and you may return the result in any order.
 */

public class IntersectionOfTwoArrays {

    /*
    Originally I thought a hashmap would be used to keep track of the occurrences of each element in both arrays, but I couldn't
    figure out how to store the minimum occurrence of the element in the 2 arrays. Since the constraints are that the elements in
    both arrays only go up to 1000, I created 2 separate arrays to keep track of occurrences for both arrays. Anytime an element
    appears in both arrays, I take the minimum occurrences and add it to a list.
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            arr2[nums2[i]]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                int min = Math.min(arr1[i], arr2[i]);

                while (min > 0) {
                    list.add(i);
                    min--;
                }
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
