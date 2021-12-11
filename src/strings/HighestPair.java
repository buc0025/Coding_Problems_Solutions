package strings;
/*
https://edabit.com/challenge/5XfpX2EEgRGWQELEx

You will be given a collection of five cards (representing a player's hand in poker). If your hand contains at least one pair,
return the card number of the highest pair (trivial if there only exists a single pair). Else, return "".
 */

public class HighestPair {

    // Still need to deal with 3 pairs or more
    public static String highestPair(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        int max = 1;
        int n = 0;

        for (String a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int m : map.values()) {
            if (m >= max) {
                max = m;
            }
        }

        if (max == 2) {
            for (String m : map.keySet()) {
                if (map.get(m) == 2) {
                    if (Character.isLetter(m.charAt(0))) {
                        for (String card : map.keySet()) {
                            if (map.get(card) == 2 && card.equals("A")) {
                                return "A";
                            } else if (map.get(card) == 2 && card.equals("K")) {
                                return "K";
                            } else if (map.get(card) == 2 && card.equals("Q")) {
                                return "Q";
                            } else if (map.get(card) == 2 && card.equals("J")) {
                                return "J";
                            }
                        }
                    } else {
                        n = Math.max(Integer.valueOf(m), n);
                    }
                }
            }
            return String.valueOf(n);
        }

        return "";
    }
}
