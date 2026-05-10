/**
 * Problem: Maximum Number of Jumps to Reach Last Index
 * Platform: LeetCode 2770
 *
 * Approach:
 * Use DFS + Memoization (Top Down DP).
 * From each index, try jumping to every next valid index.
 * Store results to avoid recomputation.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {

    private Integer[] memo;
    private int[] nums;
    private int n;
    private int target;

    public int maximumJumps(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;
        this.memo = new Integer[n];

        int ans = dfs(0);
        return ans < 0 ? -1 : ans;
    }

    private int dfs(int i) {

        // Reached last index
        if (i == n - 1) return 0;

        // Already computed
        if (memo[i] != null) return memo[i];

        int maxJumps = -(1 << 30);

        for (int j = i + 1; j < n; j++) {

            if (Math.abs(nums[i] - nums[j]) <= target) {
                maxJumps = Math.max(maxJumps, 1 + dfs(j));
            }
        }

        return memo[i] = maxJumps;
    }
}
