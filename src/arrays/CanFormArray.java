package arrays;
/*
https://leetcode.com/problems/check-array-formation-through-concatenation/
You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct.
Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers
in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 */

public class CanFormArray {

    /*
    Since the integers in both arrays are distinct, there's no reason of having to visit pieces[i][j] more than once. Once arr[i]
    matches pieces[j][0] we can look at the rest of pieces[j] and add the elements to a list. The list will be used to compare
    with arr to see if they match.
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                if (arr[i] == pieces[j][0]) {
                    int index = 0;
                    while (index < pieces[j].length) {
                        list.add(pieces[j][index]);
                        index++;
                    }
                }
            }
        }

        if (list.size() != arr.length) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != list.get(i)) {
                return false;
            }
        }

        return true;
    }
}
