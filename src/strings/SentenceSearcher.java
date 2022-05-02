package strings;
/*
https://edabit.com/challenge/mPJzNuYJoJmMiAWhh

Create a function that returns the whole of the first sentence which contains a specific word. Include the full stop at the end
of the sentence.
 */

public class SentenceSearcher {

    // 5/1/2022 solution
    public static String sentenceSearcher(String s, String w) {
        List<String> sentences = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                sentences.add(s.substring(start, i));
                start = i + 1;
            }
        }

        for (String sentence : sentences) {
            String[] words = sentence.toLowerCase().split(" ");
            for (String word : words) {
                if (word.equals(w.toLowerCase())) {
                    String result = sentence.trim();
                    return result += ".";
                }
            }
        }

        return "";
    }
}
