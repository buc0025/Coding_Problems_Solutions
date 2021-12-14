package strings;
/*
https://edabit.com/challenge/8Je7AoNP8NxPDobm8

Write a function that returns true if it's possible to build a phrase s1 using only the characters from another phrase s2.
 */

public class FridgePoetry {

    public static boolean canBuild(String s1, String s2) {
        s1 = s1.replaceAll(" ", "");
        s2 = s2.replaceAll(" ", "");

        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
