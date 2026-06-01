/*
 * Problem: Minimum Cost of Buying Candies With Discount
 * Platform: LeetCode
 * Problem Number: 2144
 *
 * Approach:
 * - Sort the candy costs in ascending order.
 * - Buy candies from the most expensive side.
 * - For every group of 3 candies:
 *      - Pay for the two most expensive.
 *      - Get the third (cheapest in the group) for free.
 * - Iterate from the end of the sorted array and
 *   add only the costs that must be paid.
 *
 * Time Complexity: O(n log n)
 *      Sorting dominates the complexity.
 *
 * Space Complexity: O(1)
 *      Ignoring the sorting space used internally.
 */
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);     
        int totalCost = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            totalCost += cost[i];         
            if (i > 0) {
                totalCost += cost[i - 1];
            }
        }    
        return totalCost;
    }
}

