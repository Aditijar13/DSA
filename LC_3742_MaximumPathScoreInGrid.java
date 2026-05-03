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
