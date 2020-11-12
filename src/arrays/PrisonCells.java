package arrays;
/*
https://leetcode.com/problems/prison-cells-after-n-days/
There are 8 prison cells in a row, and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:
If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 */
public class PrisonCells {
********Only passes given test case in random mock interview question***********
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] jail = new int[8];

        for (int day = 0; day < N; day++) {
            // Excludes first and last element since they can't have adjacent neighbors
            for (int i = 1; i < cells.length -1; i++) {
                // Populates indices 1 - 6 of jail array
                if (cells[i - 1] == cells[i + 1]) {
                    jail[i] = 1;
                } else {
                    jail[i] = 0;
                }
            }
            // Updating cells array with jail array for the next day
            for (int i = 0; i < 8; i++) {
                cells[i] = jail[i];
            }
        }

        return jail;
    }
}
