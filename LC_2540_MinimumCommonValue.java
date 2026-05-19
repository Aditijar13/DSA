/**
 * Problem: 2540. Minimum Common Value
 * Platform: LeetCode
 * 
 * Approach:
 * - Since both arrays are already sorted in non-decreasing order,
 *   use the two-pointer technique.
 * - Start one pointer at the beginning of each array.
 * - If both values are equal, return that value because it is
 *   the smallest common element encountered.
 * - If nums1[pointer1] < nums2[pointer2], move pointer1.
 * - Otherwise move pointer2.
 * 
 * Idea:
 * - Similar to merging two sorted arrays.
 * - We eliminate smaller values because they cannot become
 *   the minimum common value later.
 * 
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < nums1.length && pointer2 < nums2.length) {

            if (nums1[pointer1] == nums2[pointer2]) {
                return nums1[pointer1];
            }

            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }

        return -1;
    }
}
