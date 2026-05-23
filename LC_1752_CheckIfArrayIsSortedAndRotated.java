/*
 * Problem: Check if Array Is Sorted and Rotated
 * Platform: LeetCode
 * Problem Number: 1752
 *
 * Approach:
 * - Count the number of "break points" where nums[i] > nums[i+1].
 * - Since array is circular, use modulo for next index.
 * - A sorted & rotated array can have at most 1 break point.
 *
 * Cases:
 * - 0 breaks → already sorted (valid)
 * - 1 break  → sorted + rotated (valid)
 * - >1 break → invalid
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {

    public boolean check(int[] nums) {

        int breakCount = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int next = (i + 1) % n;

            if (nums[i] > nums[next]) {
                breakCount++;
            }

            if (breakCount > 1) {
                return false; // early exit optimization
            }
        }

        return breakCount <= 1;
    }
}
