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
