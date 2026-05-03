// Problem: Maximum Path Score in a Grid
// Approach: DFS + Memoization (3D DP)
//
// Idea:
// Move from (0,0) → (m-1,n-1)
// You can only move right or down (reverse in DFS: up or left)
//
// k = number of positive cells you can still take
//
// If current cell is positive → consume 1 from k
//
// Time Complexity: O(m * n * k)
// Space Complexity: O(m * n * k)


class Solution {
    private int[][] grid;
    private Integer[][][] dp;
    private final int NEG_INF = (int)-1e9;

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n][k + 1];

        int ans = dfs(m - 1, n - 1, k);

        return ans < 0 ? -1 : ans;
    }

 private int dfs(int i, int j, int k) {
        // Out of bounds or invalid k
        if (i < 0 || j < 0 || k < 0) return NEG_INF;

        // Base case
        if (i == 0 && j == 0) return 0;

        if (dp[i][j][k] != null) return dp[i][j][k];

        int value = grid[i][j];
        int newK = k;

        // If positive, consume k
        if (value > 0) newK--;

        int fromUp = dfs(i - 1, j, newK);
        int fromLeft = dfs(i, j - 1, newK);

        int best = value + Math.max(fromUp, fromLeft);

        return dp[i][j][k] = best;
    }
}
