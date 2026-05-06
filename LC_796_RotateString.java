// Problem: Rotate String
// Platform: LeetCode
// Approach: String Concatenation
//
// Idea:
// If goal is a rotation of s,
// then it must appear inside (s + s)
//
// Example:
// s = "abcde"
// s+s = "abcdeabcde"
// goal = "cdeab" exists inside it
//
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() &&
               (s + s).contains(goal);
    }
}
