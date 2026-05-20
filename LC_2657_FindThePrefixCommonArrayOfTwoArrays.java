/*
 * Problem: Find the Prefix Common Array of Two Arrays
 * Platform: LeetCode
 * Problem Number: 2657
 *
 * Approach:
 * - Use a single frequency array.
 * - When frequency becomes 2,
 *   that element is now common.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];

        int[] frequencyA = new int[n + 1];  
        int[] frequencyB = new int[n + 1];  
      
        for (int i = 0; i < n; i++) {
            frequencyA[A[i]]++;
            frequencyB[B[i]]++;

            for (int value = 1; value <= n; value++) {
                result[i] += Math.min(frequencyA[value], frequencyB[value]);
            }
        }
      
        return result;
    }
}
