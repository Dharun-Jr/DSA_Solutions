/*
------------------------------------------------------------
Problem Type   : BFS on Grid (Shortest Path)
Approach       : Breadth-First Search (Level-wise traversal)
Time Complexity: O(R * C)
Space Complexity: O(R * C)
------------------------------------------------------------

💡 Intuition:
- We need the shortest path from the entrance to any exit.
- Since all moves have equal cost, BFS guarantees the shortest distance.
- An exit is any boundary cell except the entrance itself.

🛠️ Strategy:
1. Start BFS from the entrance.
2. Move level by level in 4 directions.
3. The first boundary cell reached (not entrance) is the nearest exit.
4. Mark visited cells to avoid revisiting.

📌 Key Notes:
- Maze itself is used to mark visited cells.
- Distance is tracked along with row and column in the queue.

✍️ Author: Dharun JR
------------------------------------------------------------
*/

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        // Direction vectors: up, down, left, right
        int[] rdiff = {-1, 1, 0, 0};
        int[] cdiff = {0, 0, -1, 1};

        int R = maze.length;
        int C = maze[0].length;

        // Queue stores: {row, column, distance from entrance}
        Queue<int[]> queue = new LinkedList<>();

        // Start BFS from the entrance
        queue.offer(new int[] {entrance[0], entrance[1], 0});

        while (!queue.isEmpty()) {

            // Get current cell information
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            int dist = node[2];

            // Check if current cell is an exit (boundary but not entrance)
            if ((r == 0 || c == 0 || r == R - 1 || c == C - 1)
                    && !(r == entrance[0] && c == entrance[1])) {
                return dist;
            }

            // Explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newr = r + rdiff[i];
                int newc = c + cdiff[i];

                // Valid cell + open path check
                if (newr >= 0 && newc >= 0 && newr < R && newc < C
                        && maze[newr][newc] == '.') {

                    // Mark cell as visited to avoid revisiting
                    maze[newr][newc] = '+';

                    // Add new cell with incremented distance
                    queue.offer(new int[] {newr, newc, dist + 1});
                }
            }
        }

        // No exit reachable
        return -1;
    }
}
