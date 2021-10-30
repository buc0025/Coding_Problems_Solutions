package strings;
/*
https://edabit.com/challenge/ENozFXdPz9YTTHdps

Create a function that takes a string and returns the number of alphanumeric characters that occur more than once.
 */

public class CountDuplicateCharacters {

    //Could've used 2 sets to check for duplicates
    public static int duplicateCount(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (Character key : map.keySet()) {
            if (map.get(key) > 1) {
                count++;
            }
        }

        return count;
    }

    //Separate solution without map by using 2 int arrays for uppercase and lowercase letters
    public static int duplicateCount(String str) {
        int count = 0;
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 97) {
                upper[str.charAt(i) - 'A']++;
            } else {
                lower[str.charAt(i) - 'a']++;
            }
        }

        for (int low : lower) {
            if (low > 1) {
                count++;
            }
        }

        for (int up : upper) {
            if (up > 1) {
                count++;
            }
        }

        return count;
    }
}
