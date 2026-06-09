/*
 * Problem: Maximum Total Subarray Value I
 * Platform: LeetCode
 * Problem Number: 3689
 *
 * Approach:
 * - The maximum subarray value is determined by the
 *   difference between the maximum and minimum element.
 * - To maximize the total value across k selections,
 *   use the largest possible difference:
 *
 *      max(nums) - min(nums)
 *
 * - Multiply this difference by k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mx = 0, mn = 1 << 30;
        for (int x : nums) {
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
        }
        return 1L * k * (mx - mn);
    }
}
