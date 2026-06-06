/*
 * Problem: Left and Right Sum Differences
 * Platform: LeetCode
 * Problem Number: 2574
 *
 * Approach:
 * - Compute total sum of array first (rightSum).
 * - Maintain leftSum while iterating.
 * - At each index i:
 *      rightSum -= nums[i]  (exclude current element)
 *      result[i] = |leftSum - rightSum|
 *      leftSum += nums[i]
 *
 * This avoids recomputing prefix/suffix sums separately.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) extra (excluding output array)
 */
