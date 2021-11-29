package strings;
/*
https://edabit.com/challenge/w7DJWs97E83ntRgYf

Given a list of words in the singular form, return a set of those words in the plural form if they appear more than once in the
list.
 */

public class Pluralize {

    // Solution is not returning the strings in order
    public static String[] pluralize(String[] s) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : s) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String[] words = new String[map.size()];
        int index = 0;

        for (String word : map.keySet()) {
            if (map.get(word) > 1) {
                String plural = word + "s";
                words[index] = plural;
            } else {
                words[index] = word;
            }
            index++;
        }

        return words;
    }
}
