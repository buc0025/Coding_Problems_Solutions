package arrays;
/*
https://leetcode.com/problems/keyboard-row/
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American
keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".
 */

public class KeyboardRow {

    public String[] findWords(String[] words) {
        String[] first = {"q","w","e","r","t","y","u","i","o","p"};
        String[] second = {"a","s","d","f","g","h","j","k","l"};
        String[] third = {"z","x","c","v","b","n","m"};

        Set<String> row1 = new HashSet<>();
        Set<String> row2 = new HashSet<>();
        Set<String> row3 = new HashSet<>();

        for (String s : first) {
            row1.add(s);
        }

        for (String s : second) {
            row2.add(s);
        }

        for (String s : third) {
            row3.add(s);
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int len = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (row1.contains(words[i].toLowerCase().substring(j,j+1))) {
                    len++;
                } else if (row2.contains(words[i].toLowerCase().substring(j,j+1))) {
                    len--;
                } else if (row3.contains(words[i].toLowerCase().substring(j,j+1))) {
                    len+=10;
                }
            }
            if (Math.abs(len) == words[i].length() || len / 10 == words[i].length()) {
                list.add(words[i]);
            }
        }

        String[] arr = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
