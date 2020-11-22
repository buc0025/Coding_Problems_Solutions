package arrays;
/*
https://leetcode.com/problems/height-checker/
Students are asked to stand in non-decreasing order of heights for an annual photo.
Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected
students remain on their seats.
 */

public class HeightChecker {

    //Incorrect attempt to a previous problem that was never committed

    public int heightChecker(int[] heights) {
        // Thought to use a set because it'll keep the elements sorted
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int h : heights) {
            set.add(h);
        }

        // Populate list with all of set so I can get and remove elements from the front of the list
        List<Integer> list = new ArrayList<>();

        for (int s : set) {
            list.add(s);
        }

        // Idea was the iterate through array and compare with my list. If the first element in the list matches up with current
        // element in array the I continue iterating. If they don't match up, I remove the front element in list to show that a
        // we're onto a new number. Once that element is removed and if the array element doesn't match the front of the list then
        // I know it's not in order.
        for (int i = 0; i < heights.length; i++) {
            if (list.size() > 0) {
                if (heights[i] != list.get(0)) {
                    list.remove(0);
                }
                if (!list.contains(heights[i]) || list.get(0) != heights[i]) {
                    count++;
                }
            } else {
                count++;
            }
        }

        // If array is sorted, the list should end up only containing the last element
        if (list.size() > 1) {
            return list.size() - 1 + count;
        } else {
            return count;
        }
    }
}
