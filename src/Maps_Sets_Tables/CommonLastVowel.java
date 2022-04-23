package Maps_Sets_Tables;
/*
https://edabit.com/challenge/sHWvPRwcY93w6qGNB

Create a function that takes in a sentence as input and returns the most common last vowel in the sentence as a single character
string.
 */

public class CommonLastVowel {

    // 4/23/2022
    public static String commonLastVowel(String str) {
        str = str.toLowerCase();
        String[] words = str.split(" ");
        int max = 0;
        String answer = "";
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                if (set.contains(word.charAt(i))) {
                    map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0 ) + 1);
                    break;
                }
            }
        }

        for (Character vowel : map.keySet()) {
            if (map.get(vowel) > max) {
                max = Math.max(max, map.get(vowel));
                answer = String.valueOf(vowel);
            }
        }

        return answer;
    }
}
