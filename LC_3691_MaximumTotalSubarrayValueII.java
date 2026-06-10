/*
 * Problem: Maximum Total Subarray Value II
 * Platform: LeetCode
 * Problem Number: 3691
 *
 * Approach:
 * - For a subarray:
 *      value = max(subarray) - min(subarray)
 *
 * - Use Sparse Tables to answer:
 *      Range Maximum Query (RMQ)
 *      Range Minimum Query (RMQ)
 *   in O(1) time.
 *
 * - For each starting index l:
 *      Consider the largest interval [l, n-1].
 *      Compute its value and push into a max heap.
 *
 * - Greedily select the current maximum-value
 *   subarray from the heap.
 *
 * - After taking interval [l, r]:
 *      Generate the next candidate [l, r-1]
 *      and push it into the heap.
 *
 * - Repeat k times and accumulate the answer.
 *
 * Time Complexity:
 *      Sparse Table Build: O(n log n)
 *      Heap Operations: O(k log n)
 *
 * Overall:
 *      O(n log n + k log n)
 *
 * Space Complexity:
 *      O(n log n)
 */
