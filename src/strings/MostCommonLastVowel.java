package strings;
/*
https://edabit.com/challenge/sHWvPRwcY93w6qGNB

Create a function that takes in a sentence as input and returns the most common last vowel in the sentence as a single character
string.
 */

public class MostCommonLastVowel {

    public static String commonLastVowel(String sentence) {
        sentence = sentence.toLowerCase();
        Set<Character> vowels = new HashSet<>();
        String[] words = sentence.split(" ");
        Map<Character, Integer> map = new HashMap<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int max = 0;
        String result = "";

        for (String word : words) {
            char last = word.charAt(word.length() - 1);
            if (vowels.contains(last)) {
                if (map.containsKey(last)) {
                    map.put(last, map.get(last) + 1);
                } else {
                    map.put(last, 1);
                }

                if (map.get(last) > max) {
                    max = map.get(last);
                }
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) == max) {
                result = Character.toString(c);
            }
        }

        return result;
    }
}
