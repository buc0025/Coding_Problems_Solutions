package strings;
/*
Coding assessment problem from Whole Foods.
Write an algorithm to determine whether a collection of tiles can be rearranged to form a given word. Each tile has 1..N letters.
You do not have to use each tile, but you cannot use any tile more than once. There can be several identical tiles.

String word = "foobarbaz"
String[] arr = {"foob", "foo", "ba", "ba", "r", "z"};
Answer = true
 */

import java.util.HashSet;
import java.util.Set;

public class TileArranger {

    public static boolean tileArranger(String s, String[] arr) {
        Set<Integer> set = new HashSet<>(); // makes sure tile is only used once
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            /* If the substring of s is equal to the word in the array then enter second loop to search for next matching word in
            substring
            */
            if (s.substring(index, index + word.length()).equals(word)) {
                set.add(i);
                index += word.length();
                for (int j = 0; j < arr.length; j++) {
                    String word2 = arr[j];
                    /* If the substring of s is equal to the word in the array then start next iteration at j to search for next
                    matching word in substring
                    */
                    if (!set.contains(j) && s.substring(index, index + word2.length()).equals(word2)) {
                        set.add(j);
                        index += word2.length();
                        i = j;
                        break;
                    }
                }
            }
            if (index == s.length() - 1) {
                return true;
            }
            // start over from the beginning of the given string for comparison and clear the set.
            index = 0;
            set.clear();
        }

        return false;
    }

    public static void main(String[] args) {
        String word = "foobarbaz";
        String[] arr = {"foob", "foo", "ba", "ba", "r", "z"};
        System.out.println(tileArranger(word, arr));
    }


}
