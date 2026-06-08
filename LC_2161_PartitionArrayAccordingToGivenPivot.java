/*
 * Problem: Partition Array According to Given Pivot
 * Platform: LeetCode
 * Problem Number: 2161
 *
 * Approach:
 * - Create a result array of the same size.
 * - Traverse the array three times:
 *      1. Place all elements smaller than pivot.
 *      2. Place all elements equal to pivot.
 *      3. Place all elements greater than pivot.
 * - This preserves the relative order of elements
 *   within each group (stable partition).
 *
 * Time Complexity: O(n)
 *      Three linear traversals.
 *
 * Space Complexity: O(n)
 *      Result array.
 */
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
      
        int[] result = new int[n];
      
        int index = 0;
      
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }
      
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }
      
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }
      
        return result;
    }
}
