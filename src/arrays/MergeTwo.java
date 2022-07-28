package arrays;
/*
https://codingbat.com/prob/p139150

Start with two arrays of strings, A and B, each with its elements in alphabetical order and without duplicates. Return a new array
containing the first N elements from the two arrays. The result array should be in alphabetical order and without duplicates. A
and B will both have a length which is N or more. The best "linear" solution makes a single pass over A and B, taking advantage of
the fact that they are in alphabetical order, copying elements directly to the new array.


 */

public class MergeTwo {

    // 7/27/2022 solution
    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] arr = new String[n];
        int[] letters = new int[26];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            letters[a[i].charAt(0) - 'a']++;
        }

        for (int i = 0; i < b.length; i++) {
            letters[b[i].charAt(0) - 'a']++;
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                int num = 97 + i;
                char c = (char) num;
                String letter = Character.toString(c);
                arr[index] = letter;
                index++;
            }
            if (index == n) {
                break;
            }
        }

        return arr;
    }
}
