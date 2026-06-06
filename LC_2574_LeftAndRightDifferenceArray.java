/*
 * Problem: Left and Right Sum Differences
 * Platform: LeetCode
 * Problem Number: 2574
 *
 * Approach:
 * - First calculate the total sum of the array.
 * - Use rightSum to represent the sum of elements
 *   to the right of the current index.
 * - Use leftSum to represent the sum of elements
 *   to the left of the current index.
 * - For each index:
 *      1. Remove current element from rightSum.
 *      2. Compute absolute difference.
 *      3. Add current element to leftSum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) extra space
 *                  (excluding output array)
 */
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            result[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return result;
    }
}
