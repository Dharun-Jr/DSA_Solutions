/*
 PROBLEM:
 --------
 Given a 2D grid of characters:
 '1' -> land
 '0' -> water

 An island is formed by connected lands (up, down, left, right).

 TASK:
 -----
 Count how many islands are present in the grid.

 APPROACH (DFS):
 ---------------
 1. Traverse every cell in the grid.
 2. When a '1' (land) is found:
    - Increment island count.
    - Use DFS to visit and remove the entire island.
 3. DFS marks visited land as '0' to avoid revisiting.
*/

class Solution {

    int R, C; // number of rows and columns

    // Main function that counts islands
    public int numIslands(char[][] grid) {

        // total rows and columns
        R = grid.length;
        C = grid[0].length;

        int islands = 0;

        // Traverse the entire grid
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                // If land is found, it's a new island
                if (grid[r][c] == '1') {
                    islands++;        // count the island
                    dfs(grid, r, c);  // remove the whole island using DFS
                }
            }
        }

        return islands;
    }

    /*
     DFS FUNCTION:
     -------------
     This function visits all connected land cells
     starting from (r, c) and marks them as water ('0').

     IMPORTANT:
     ----------
     - grid is passed by reference in Java
     - Changes made here affect the original matrix
    */
    public static void dfs(char[][] grid, int r, int c) {

        // Base case:
        // Stop DFS if:
        // 1. Out of grid boundaries
        // 2. Cell is water ('0')
        if (r < 0 || c < 0 ||
            r >= grid.length || c >= grid[0].length ||
            grid[r][c] == '0') {
            return;
        }

        // Mark current land as visited (convert to water)
        grid[r][c] = '0';

        // Explore all 4 directions

        // up
        dfs(grid, r - 1, c);

        // down
        dfs(grid, r + 1, c);

        // left
        dfs(grid, r, c - 1);

        // right
        dfs(grid, r, c + 1);
    }
}
