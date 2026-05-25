/*
 * Problem: Jump Game VII
 * Platform: LeetCode
 * Problem Number: 1871
 *
 * Approach:
 * - Use Dynamic Programming + Prefix Sum.
 * - dp[i] stores whether index i is reachable.
 * - For each index i:
 *      We need to know whether there exists a reachable
 *      index j such that:
 *
 *      i - maxJump <= j <= i - minJump
 *
 * - Prefix sum helps efficiently count reachable
 *   positions in that range in O(1).
 * - If count > 0, current position becomes reachable.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

