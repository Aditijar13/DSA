/*
 * Problem: Sum of Sortable Integers
 * Platform: LeetCode
 *
 * Approach:
 * - Find all divisors of the array length.
 * - Use prefix maximums and suffix minimums to check
 *   ordering conditions between array segments.
 * - Use a prefix array to count adjacent decreasing pairs.
 * - Check whether each divisor forms valid sortable segments.
 * - Add all valid segment sizes to the answer.
 *
 * Time Complexity: O(n * sqrt(n))
 * Space Complexity: O(n)
 */

class Solution {

    public int sortableIntegers(int[] nums) {

        int n = nums.length;

        int[] prefMax = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        int[] suffMin = new int[n + 1];
        suffMin[n] = 1000000000;

        for (int i = n - 1; i >= 0; --i) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        int[] prefDrop = new int[n];

        for (int i = 1; i < n; ++i) {
            prefDrop[i] = prefDrop[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int ans = 0;

        // Check all divisors of n
        for (int i = 1; i <= n / i; ++i) {

            if (n % i == 0) {

                if (check(nums, prefMax, suffMin, prefDrop, i)) {
                    ans += i;
                }

                int other = n / i;

                if (i != other &&
                    check(nums, prefMax, suffMin, prefDrop, other)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean check(
            int[] nums,
            int[] prefMax,
            int[] suffMin,
            int[] prefDrop,
            int k) {

        int n = nums.length;

        for (int start = 0; start < n; start += k) {

            int end = start + k - 1;

            int drops = prefDrop[end] - prefDrop[start];

            if (nums[end] > nums[start]) {
                ++drops;
            }

            // More than one decreasing pair makes the segment invalid
            if (drops > 1 || prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}
