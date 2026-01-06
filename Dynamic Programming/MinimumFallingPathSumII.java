import java.util.*;

/*
 * Problem Type: Dynamic Programming on Matrix (Row-wise decisions)
 *
 * Goal:
 * Pick exactly ONE element from each row such that
 *   - You do NOT pick the same column in consecutive rows
 *   - Total sum is maximized
 *
 * dp[r][c] =
 *   Maximum possible sum up to row 'r'
 *   if we choose column 'c' in that row
 *
 * Answer =
 *   Maximum value in the last row of dp
 */

public class HighestPossibleSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();   // number of rows
        int C = sc.nextInt();   // number of columns

        int[][] mat = new int[R][C]; // original matrix
        int[][] dp  = new int[R][C]; // dp table

        // read matrix values
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                mat[r][c] = sc.nextInt();
            }
        }

        // Base Case:
        // First row has no restriction because there's no previous row
        for (int c = 0; c < C; c++) {
            dp[0][c] = mat[0][c];
        }

        // Build dp row by row
        for (int r = 1; r < R; r++) {

            for (int c = 0; c < C; c++) {

                // We want the best sum from previous row
                // BUT NOT from the same column
                int bestPrev = Integer.MIN_VALUE;

                for (int k = 0; k < C; k++) {
                    if (k != c) {
                        bestPrev = Math.max(bestPrev, dp[r - 1][k]);
                    }
                }

                // Current cell value + best valid previous sum
                dp[r][c] = bestPrev + mat[r][c];
            }
        }

        // Final Answer:
        // The path may end in ANY column of the last row
        int result = Integer.MIN_VALUE;
        for (int c = 0; c < C; c++) {
            result = Math.max(result, dp[R - 1][c]);
        }

        System.out.println(result);

        sc.close();
    }
}
