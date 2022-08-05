package Maps_Sets_Tables;
/*
https://leetcode.com/problems/most-common-word/
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is
guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 */

public class MostCommonWord {

    // 8/4/2022 unfinished solution
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");

        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (word.length() > 0) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        int max = 0;
        String answer = "";

        if (banned.length == 0) {
            for (String key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    answer = key;
                }
            }
            return answer;
        }

        for (String key : map.keySet()) {
            boolean isBanned = false;
            for (String ban : banned) {
                if (!key.equals(ban)) {
                    if (map.get(key) > max) {
                        max = map.get(key);
                        answer = key;
                    }
                } else {
                    isBanned = true;
                    break;
                }
            }
        }

        return answer;
    }

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
