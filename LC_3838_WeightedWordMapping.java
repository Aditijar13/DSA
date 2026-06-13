/*
 * Problem: Weighted Word Mapping
 * Platform: LeetCode
 * Problem Number: 3838
 *
 * Approach:
 * - For each word:
 *      1. Compute the sum of weights of all characters.
 *      2. Take the sum modulo 26.
 *      3. Map it to a character using:
 *
 *          'a' + (25 - sum)
 *
 * - Append the resulting character to the answer.
 *
 * Time Complexity: O(T)
 *      T = Total number of characters across all words.
 *
 * Space Complexity: O(1)
 *      Excluding the output StringBuilder.
 */
