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
}
