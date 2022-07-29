package arrays;
/*
https://leetcode.com/problems/design-hashset/

Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 */

public class MyHashSet {
    List<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        boolean noKey = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                noKey = false;
                break;
            }
        }
        if (noKey) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            list.remove(index);
        }
    }

    public boolean contains(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                return true;
            }
        }
        return false;
    }
}
