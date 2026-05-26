/*
 * Problem: Count the Number of Special Characters I
 * Platform: LeetCode
 * Problem Number: 3120
 *
 * Approach:
 * - Use a boolean presence array to track
 *   whether each character exists.
 * - Traverse the string and mark characters.
 * - Check for each alphabet whether both
 *   lowercase and uppercase versions exist.
 * - Count such characters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *      (Fixed size array)
 */
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] characterPresence = new boolean['z' + 1];
      
        for (int i = 0; i < word.length(); i++) {
            characterPresence[word.charAt(i)] = true;
        }
      
        int specialCharCount = 0;
      
        for (int i = 0; i < 26; i++) {
            if (characterPresence['a' + i] && characterPresence['A' + i]) {
                specialCharCount++;
            }
        }
      
        return specialCharCount;
    }
}
