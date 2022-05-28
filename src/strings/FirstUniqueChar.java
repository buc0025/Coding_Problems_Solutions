package strings;
/*
https://leetcode.com/problems/first-unique-character-in-a-string/
Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

public class FirstUniqueChar {

    // 5/27/2022 solution
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    /*
    First thought was to use a map since it'll keep track of the frequency of each char. The runtime is o(n) but it was slow during
    submission. Since the constraint was the string having only lowercase letters, I used an int array to represent the 26 letters
    and increment each element whenever they appear in the string. Space would've improved slightly if I didn't use a variable
    for index and just returned i in the second loop and -1 if it was never found.
     */

    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }
        }

        return index;
    }
}
