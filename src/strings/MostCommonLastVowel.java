package strings;
/*
https://edabit.com/challenge/sHWvPRwcY93w6qGNB

Create a function that takes in a sentence as input and returns the most common last vowel in the sentence as a single character
string.
 */

public class MostCommonLastVowel {

    //Fix test cases where words don't have vowels at the end
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
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (vowels.contains(c)) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    if (map.get(c) > max) {
                        max = map.get(c);
                    }
                    break;
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
