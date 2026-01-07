import java.util.*;

/*
 PROBLEM:
 --------
 Given a 2D grid where:
 '1' represents land
 '0' represents water

 An island is formed by connecting adjacent lands
 (up, down, left, right).

 TASK:
 -----
 Count the number of islands in the grid.

 APPROACH:
 ---------
 Use Breadth First Search (BFS).

 - Traverse the entire grid.
 - When an unvisited land cell ('1') is found:
     • Increment island count.
     • Use BFS to visit and remove the entire island.
 - Mark visited land as '0' to avoid revisiting.
*/

class Solution {

    int R, C; // number of rows and columns in the grid

    // Main function to count islands
    public int numIslands(char[][] grid) {

        // Initialize grid dimensions
        R = grid.length;
        C = grid[0].length;

        int islands = 0; // island counter

        // Traverse every cell in the grid
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                // If land is found, it is a new island
                if (grid[r][c] == '1') {
                    islands++;           // count this island
                    bfs(grid, r, c);     // remove the entire island using BFS
                }
            }
        }

        return islands;
    }

    /*
     BFS FUNCTION:
     -------------
     Starting from cell (r, c), this function visits all
     connected land cells and marks them as water ('0').

     Why this works:
     - Java passes arrays by reference.
     - Changes made here affect the original grid.
     - Once land is marked '0', it will not be counted again.
    */
    public static void bfs(char[][] grid, int r, int c) {

        // Queue to store cells to be processed (row, col)
        Queue<int[]> queue = new LinkedList<>();

        // Direction arrays for movement:
        // up, down, left, right
        int[] rdiff = {-1, 1, 0, 0};
        int[] cdiff = {0, 0, -1, 1};

        // Add the starting land cell to the queue
        queue.add(new int[]{r, c});

        // Mark the starting cell as visited
        grid[r][c] = '0';

        // Continue BFS until all connected cells are processed
        while (!queue.isEmpty()) {

            // Remove the front cell from the queue
            int[] ind = queue.remove();
            int row = ind[0];
            int col = ind[1];

            // Explore all 4 possible directions
            for (int k = 0; k < 4; k++) {

                int newr = row + rdiff[k];
                int newc = col + cdiff[k];

                // Check:
                // 1. Inside grid boundaries
                // 2. Cell is land ('1')
                if (newr >= 0 && newc >= 0 &&
                    newr < grid.length &&
                    newc < grid[0].length &&
                    grid[newr][newc] == '1') {

                    // Mark land as visited
                    grid[newr][newc] = '0';

                    // Add this cell to the queue for further exploration
                    queue.add(new int[]{newr, newc});
                }
            }
        }
    }
}
