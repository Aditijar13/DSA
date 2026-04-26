// Problem: Furthest Point From Origin
// Platform: LeetCode
// Approach: Counting + Greedy
//
// Idea:
// Count number of 'L', 'R', and '_' (wildcards).
// To maximize distance, assign all '_' in one direction.
//
// Distance = |L - R| + wildcardCount
//
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, wildcard = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') left++;
            else if (ch == 'R') right++;
            else wildcard++;
        }

        return Math.abs(left - right) + wildcard;
    }
}
