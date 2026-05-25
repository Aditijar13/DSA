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
class Solution {
    public boolean canReach(String s,int minJump,int maxJump){
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        prefixSum[1] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {

                int left = Math.max(0,i - maxJump);
                int right = i - minJump;
                if (left <= right &&
                    prefixSum[right + 1] -
                    prefixSum[left] > 0) {
                    reachable[i] = true;
                }
            }
            prefixSum[i + 1] = prefixSum[i] +(reachable[i] ? 1 : 0);
        }

        return reachable[n - 1];
    }
}
