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
class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();
      
        int n = nums.length;
      
        int[] result = new int[n];
      
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
          
            result[i] = Math.abs(leftSum - rightSum);
          
            leftSum += nums[i];
        }
      
        return result;
    }
}
