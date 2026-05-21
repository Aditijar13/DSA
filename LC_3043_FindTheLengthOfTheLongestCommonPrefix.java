/*
 * Problem: Find the Length of the Longest Common Prefix
 * Platform: LeetCode
 * Problem Number: 3043
 *
 * Approach:
 * - Store all prefixes of numbers from arr1 in a HashSet.
 * - Generate prefixes by repeatedly dividing by 10.
 * - For each number in arr2, keep removing the last digit
 *   until a prefix exists in the set.
 * - Update the maximum prefix length found.
 *
 * Time Complexity: O((n + m) * d)
 *      n = size of arr1
 *      m = size of arr2
 *      d = number of digits (max 9)
 *
 * Space Complexity: O(n * d)
 */
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixSet = new HashSet<>();

        for (int number : arr1) {
            while (number > 0) {
                prefixSet.add(number);
                number /= 10;  
            }
        }
      
        int maxPrefixLength = 0;
      
        for (int number : arr2) {
            while (number > 0) {
                if (prefixSet.contains(number)) {
                    int currentPrefixLength = String.valueOf(number).length();
                    maxPrefixLength = Math.max(maxPrefixLength, currentPrefixLength);
                    break;  
                }
                number /= 10;  
        }
      
        return maxPrefixLength;
    }
}


