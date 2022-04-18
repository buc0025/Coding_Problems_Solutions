package strings;
/*
https://edabit.com/challenge/v9YKCBnGLJh8ZobKj

Write a method that accepts two integer parameters rows and cols. The output is a comma-separated grid of numbers displayed in
column-major order, meaning the numbers shown increase sequentially down each column and wrap to the top of the next column to the
right once the bottom of the current column is reached.
 */

public class PrintGrid {

    // 4/17/2022 solution
    public static String printGrid(int rows, int cols) {
        int colNum = 1;
        String grid = "";

        for (int i = 0; i < rows; i++) {
            int rowNum = colNum;
            for (int j = 0; j < cols; j++) {
                String n = String.valueOf(rowNum);
                if (j == 0 && j != (cols - 1)) {
                    grid += n + ", ";
                } else if (j == (cols - 1)) {
                    grid += n;
                } else {
                    grid += n + ", ";
                }
                rowNum += rows;
            }
            if (i != rows - 1) {
                grid += "\n";
            }
            colNum++;
        }

        return grid;
    }
}
