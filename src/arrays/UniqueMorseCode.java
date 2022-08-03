package arrays;
/*
https://leetcode.com/problems/unique-morse-code-words/
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
"...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a
concatenation the transformation of a word.
Return the number of different transformations among all words we have.
 */

public class UniqueMorseCode {

    // 8/2/2022 solution
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();

        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int n = word.charAt(i) - 'a';
                builder.append(morse[n]);
            }
            set.add(builder.toString());
        }

        return set.size();
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {

            for (int i = 0; i < word.length(); i++) {
                int val = word.charAt(i) - 97;
                stringBuilder.append(arr[val]);
            }

            set.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        return set.size();
    }
}
