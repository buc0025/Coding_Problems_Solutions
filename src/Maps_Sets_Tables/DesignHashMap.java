package Maps_Sets_Tables;
/*
https://leetcode.com/problems/design-hashmap/
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the
corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 */

public class DesignHashMap {

    List<Integer> keys;
    List<Integer> values;
    int[] map;

    //********************* Uses one array *************************************************************
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000001];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        // Arrays.fill(map, -1); *** use this in place of for loop to fill array ***
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }

    //********************* Uses two lists *************************************************************

    /** Initialize your data structure here. */
    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (keys.contains(key)) {
            values.remove(keys.indexOf(key));
            values.add(keys.indexOf(key), value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (keys.contains(key)) {
            return values.get(keys.indexOf(key));
        } else {
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            keys.remove(index);
            values.remove(index);
        }
    }
}
