package arrays;
/*
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards,
where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 */

public class HasGroupsSizeX {

    // 9/19/2022 incorrect solution
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : deck) {
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int key : map.keySet()) {
            set.add(map.get(key));
        }

        int[] arr = new int[set.size()];
        int index = 0;

        for (int s : set) {
            if (s == 1) {
                return false;
            }
            arr[index] = s;
            index++;
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] % 2 == 0 && arr[j] % 2 != 0) {
                    return false;
                } else if (arr[i] % 3 == 0 && arr[j] % 3 != 0) {
                    return false;
                } else if (arr[i] % 5 == 0 && arr[j] % 5 != 0) {
                    return false;
                } else if (arr[i] % 7 == 0 && arr[j] % 7 != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
