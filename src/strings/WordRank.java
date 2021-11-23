package strings;
/*
https://edabit.com/challenge/63GZYcgtT7XiSjsKL

Create a function that takes a string of words and returns the highest scoring word. Each letter of a word scores points according
to it's position in the alphabet: a = 1, b = 2, c = 3, etc.
 */

public class WordRank {

    public static String word_rank(String str) {
        String[] words = str.split(" ");
        int[] nums = new int[words.length];
        int max = 0;
        String result = "";

        for (int i = 0; i < words.length; i++) {
            int score = 0;
            String word = words[i].toLowerCase();
            for (int j = 0; j < word.length(); j++) {
                if (Character.isLetter(word.charAt(j))) {
                    score += word.charAt(j) - 'a' + 1;
                }
            }
            nums[i] = score;
            max = Math.max(score, max);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (Character.isLetter(words[i].charAt(j))) {
                        result += words[i].charAt(j);
                    }
                }
            }
        }

        return result;
    }

    // Incorrect solution. Also returns punctuation.
    public static String word_rank(String str) {
        String[] words = str.split(" ");
        int[] nums = new int[words.length];
        int max = 0;
        String result = "";

        for (int i = 0; i < words.length; i++) {
            int score = 0;
            String word = words[i].toLowerCase();
            for (int j = 0; j < word.length(); j++) {
                if (Character.isLetter(word.charAt(j))) {
                    score += word.charAt(j) - 'a';
                }
            }
            nums[i] = score;
            max = Math.max(score, max);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                return words[i];
            }
        }

        return "not found";
    }
}
