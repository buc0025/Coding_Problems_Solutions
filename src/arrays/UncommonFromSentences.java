package arrays;
/*
https://leetcode.com/problems/uncommon-words-from-two-sentences/
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase
letters.)
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Return a list of all uncommon words.
You may return the list in any order.
 */

public class UncommonFromSentences {

    public String[] uncommonFromSentences(String A, String B) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String[] aWords = A.split(" ");
        String[] bWords = B.split(" ");

        for (String word : aWords) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : bWords) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                list.add(word);
            }
        }

        String[] arr = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
