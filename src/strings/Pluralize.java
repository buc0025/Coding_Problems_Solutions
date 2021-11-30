package strings;
/*
https://edabit.com/challenge/w7DJWs97E83ntRgYf

Given a list of words in the singular form, return a set of those words in the plural form if they appear more than once in the
list.
 */

public class Pluralize {

    // Top result uses arraylist to keep track of plurals using contains() and replacing position of word with 's' at the end if
    // it appears in array again
    public static String[] pluralize(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String word : s) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            set.add(word);
        }

        String[] words = new String[map.size()];
        int index = 0;

        for (String word : s) {
            if (set.contains(word)) {
                if (map.get(word) > 1) {
                    String plural = word + "s";
                    words[index] = plural;
                } else {
                    words[index] = word;
                }
                index++;
            }
            set.remove(word);
        }

        return words;
    }
}
