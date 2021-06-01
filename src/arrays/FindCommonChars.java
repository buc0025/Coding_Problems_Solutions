package arrays;
/*
https://leetcode.com/problems/find-common-characters/
Given an array words of strings made only from lowercase letters, return a list of all characters that show up in all strings
within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to
include that character three times in the final answer.

You may return the answer in any order.
 */

public class FindCommonChars {

    /*
    Solution below was duplicated from a top answer in discussion. The wordToArray() looks at the first element in the string array.
    That array will be compared to the next element in the string array until the very end. When the int arrays are being compared,
    we take the smaller occurrence of a specific letter from the 2 arrays. The letters from the int array at the very end is then
    extracted and added onto a list and returned.
     */
    public List<String> commonChars(String[] words) {
        int[] last = wordToArray(words[0]);

        for (int i = 1; i < words.length; i++) {
            last = compareArrays(last, wordToArray(words[i]));
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    list.add(s);
                    last[i]--;
                }
            }
        }

        return list;
    }

    public static int[] compareArrays(int[] arr1, int[] arr2) {
        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = Math.min(arr1[i], arr2[i]);
        }

        return arr;
    }

    public static int[] wordToArray(String word) {
        int[] arr = new int[26];

        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }

        return arr;
    }
}
