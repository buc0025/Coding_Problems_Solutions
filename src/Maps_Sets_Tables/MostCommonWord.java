package Maps_Sets_Tables;
/*
https://leetcode.com/problems/most-common-word/
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is
guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 */

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        // Get rid of all special characters and turn string to lowercase letters only
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        Map<String, Integer> map = new HashMap<>(); // keeps track of most common word

        for (String ban : banned) {
            paragraph = paragraph.replaceAll(ban, "");
        }

        String[] words = paragraph.split(" ");

        int max = 1;

        for (String w : words) {
            if (w.length() > 0) { // String array may contain empty strings
                map.put(w, map.getOrDefault(w, 0) + 1);
                if (map.get(w) >= max) {
                    max = map.get(w);
                }
            }
        }

        for (String word : map.keySet()) {
            if (map.get(word) == max) {
                return word;
            }
        }

        return "";
    }
}
