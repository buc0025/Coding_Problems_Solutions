package Maps_Sets_Tables;
/*
https://leetcode.com/problems/find-and-replace-pattern/
You have a list of words and a pattern, and you want to know which words in words matches the pattern.
A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the
pattern with p(x), we get the desired word. (Recall that a permutation of letters is a bijection from letters to
letters: every letter maps to another letter, and no two letters map to the same letter.) Return a list of the words in
words that match the given pattern. You may return the answer in any order.
 */

public class ReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();

        for (String word : words) {
            if (matchPat(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    public boolean matchPat(String word, String pattern) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        if (word.length() != pattern.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char wc = word.charAt(i);
            char pc = pattern.charAt(i);
            // Checks to see if map1's value is the same at char at pattern's i'th index
            if (map1.containsKey(wc) && map1.get(wc) != pc) {
                return false;
            } else {
                map1.put(wc, pc);
            }
            // Checks to see if map2's value is the same at char at word's i'th index
            if (map2.containsKey(pc) && map2.get(pc) != wc) {
                return false;
            } else {
                map2.put(pc, wc);
            }
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();

        for (String word : words) {
            if (match(word, pattern)) {
                list.add(word);
            }
        }

        return list;
    }

    public boolean match(String word, String pattern) {
        // Assigns elements of word as values to key elements in pattern
        Map<Character, Character> pat = new HashMap<>();
        // Assigns elements of pattern as values to key elements in word
        Map<Character, Character> words = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if (pat.containsKey(pattern.charAt(i))) {
                // Crisscross examination
                if (word.charAt(i) != pat.get(pattern.charAt(i))) {
                    return false;
                }
            }

            if (words.containsKey(word.charAt(i))) {
                // Crisscross examination
                if (pattern.charAt(i) != words.get(word.charAt(i))) {
                    return false;
                }
            }
            pat.put(pattern.charAt(i), word.charAt(i));
            words.put(word.charAt(i), pattern.charAt(i));
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (samePattern(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    public boolean samePattern(String word, String pattern) {
        Map<Character, Character> wordMap = new HashMap<>();
        Map<Character, Character> patternMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!wordMap.containsKey(w)) {
                wordMap.put(w, p);
            }
            if (!patternMap.containsKey(p)) {
                patternMap.put(p, w);
            }
            if (wordMap.get(w) != p || patternMap.get(p) != w) {
                return false;
            }
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        // Assigning chars and frequency of occurrences in given pattern
        Map<Character, Integer> patternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                patternMap.put(pattern.charAt(i), patternMap.get(pattern.charAt(i)) + 1);
            } else {
                patternMap.put(pattern.charAt(i), 1);
            }
        }

        Map<Character, Integer> wordMap = new HashMap<>();

        int val = 0; // Used to compare same values in both maps

        for (int i = 0; i < words.length; i++) {
            // Assigning chars and frequency of occurrences for each word in given array
            for (int j = 0; j < words[i].length(); j++) {
                if (wordMap.containsKey(words[i].charAt(j))) {
                    wordMap.put(words[i].charAt(j), wordMap.get(words[i].charAt(j))+1);
                } else {
                    wordMap.put(words[i].charAt(j), 1);
                }
            }
            // Comparing values for each key in both maps and increment values if they match
            for (int n = 0; n < words[i].length(); n++) {
                if (wordMap.get(words[i].charAt(n)) == patternMap.get(pattern.charAt(n))) {
                    val++;
                }
            }
            // If both maps' values match then add word to list
            if (val >= pattern.length()) {
                result.add(words[i]);
            }
            // Clear the value and wordMap for each new word in array
            val = 0;
            wordMap.clear();
        }
        return result;
    }
}
