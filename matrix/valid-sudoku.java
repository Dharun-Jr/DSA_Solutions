/*
 * LeetCode 36 - Valid Sudoku
 *
 * Goal:
 * Check if a given 9x9 Sudoku board is valid.
 *
 * Rules:
 * 1) No duplicate numbers (1–9) in any row.
 * 2) No duplicate numbers in any column.
 * 3) No duplicate numbers in any 3x3 box.
 *
 * Important:
 * - Empty cells are represented by '.'
 * - We only validate existing numbers.
 */

class Solution {

    public boolean isValidSudoku(char[][] board) {

        // rows[i][num] → tells whether number (num+1)
        // has already appeared in row i.
        boolean[][] rows = new boolean[9][9];

        // cols[j][num] → tells whether number (num+1)
        // has already appeared in column j.
        boolean[][] cols = new boolean[9][9];

        // boxes[k][num] → tells whether number (num+1)
        // has already appeared in 3x3 box k.
        boolean[][] boxes = new boolean[9][9];

        // Loop through every cell in the board
        for (int i = 0; i < 9; i++) {         // i = row index
            for (int j = 0; j < 9; j++) {     // j = column index

                char current = board[i][j];   // Get the current cell value

                // If the cell is empty, skip it
                if (current == '.') {
                    continue;
                }

                // Convert character '1'–'9' to index 0–8
                // Example:
                // '1' - '1' = 0
                // '5' - '1' = 4
                // '9' - '1' = 8
                int num = current - '1';

                /*
                 * Determine which 3x3 box this cell belongs to.
                 *
                 * i / 3 → gives box row group (0,1,2)
                 * j / 3 → gives box column group (0,1,2)
                 *
                 * Formula:
                 * boxIndex = (i / 3) * 3 + (j / 3)
                 *
                 * This converts (row group, column group)
                 * into a number between 0 and 8.
                 */
                int boxIndex = (i / 3) * 3 + (j / 3);

                /*
                 * Check if this number already appeared before.
                 *
                 * If:
                 * - rows[i][num] is true → duplicate in row
                 * - cols[j][num] is true → duplicate in column
                 * - boxes[boxIndex][num] is true → duplicate in box
                 *
                 * Then the board is invalid.
                 */
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;  // Stop immediately
                }

                /*
                 * If number was not seen before,
                 * mark it as seen in row, column, and box.
                 */
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        // If we finish checking all cells and find no duplicates,
        // the board is valid.
        return true;
    }
}
