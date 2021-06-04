package arrays;
/*
https://leetcode.com/problems/occurrences-after-bigram/
Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes
immediately after first, and third comes immediately after second.

Return an array of all the words third for each occurrence of "first second third".
 */

public class FindOccurrences {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();

        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                list.add(words[i]);
            }
        }

        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
