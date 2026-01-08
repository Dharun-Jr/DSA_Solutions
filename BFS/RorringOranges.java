class Solution {
    public int orangesRotting(int[][] grid) {

        /* 
         * Grid dimensions
         * R -> number of rows
         * C -> number of columns
         */
        int R = grid.length;
        int C = grid[0].length;

        /*
         * Direction vectors to move in 4 directions:
         * up, down, left, right
         */
        int[] rdiff = {-1, 1, 0, 0};
        int[] cdiff = {0, 0, -1, 1};

        /*
         * Queue for BFS
         * Each element stores: {row, column}
         */
        Queue<int[]> queue = new LinkedList<>();

        /*
         * Count of fresh oranges (value = 1)
         * Used to check if all oranges can be rotted
         */
        int fresh = 0;

        /*
         * STEP 1: Scan the grid
         * - Add all rotten oranges (value = 2) into the queue
         * - Count all fresh oranges
         *
         * This makes it a MULTI-SOURCE BFS
         */
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        /*
         * Minutes required to rot all reachable fresh oranges
         * Each BFS level represents 1 minute
         */
        int minutes = 0;

        /*
         * STEP 2: Perform BFS level by level
         * Continue while:
         * - there are rotten oranges to spread from
         * - fresh oranges still exist
         */
        while (!queue.isEmpty() && fresh > 0) {

            /*
             * Number of rotten oranges at the current minute
             * Only these should spread rot in this minute
             */
            int size = queue.size();

            // One BFS level completed → one minute passed
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                /*
                 * Try to rot adjacent fresh oranges
                 */
                for (int k = 0; k < 4; k++) {
                    int nr = r + rdiff[k];
                    int nc = c + cdiff[k];

                    /*
                     * Conditions:
                     * - inside grid boundaries
                     * - cell contains a fresh orange (1)
                     */
                    if (nr >= 0 && nc >= 0 && nr < R && nc < C
                            && grid[nr][nc] == 1) {

                        // Mark the fresh orange as rotten
                        grid[nr][nc] = 2;

                        // Decrease fresh orange count
                        fresh--;

                        // Add newly rotten orange to queue
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        /*
         * STEP 3: Final check
         * If fresh oranges still exist, return -1
         * Otherwise, return total minutes taken
         */
        return fresh == 0 ? minutes : -1;
    }
}
