/*
 * Problem: Maximum Twin Sum of a Linked List
 * Platform: LeetCode
 * Problem Number: 2130
 *
 * Approach:
 * - Store all node values in an ArrayList.
 * - Use two-pointer indexing:
 *      i and (n - 1 - i)
 * - Compute twin sums and track maximum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {

    public int pairSum(ListNode head) {

        List<Integer> values = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int maxTwinSum = 0;
        int n = values.size();

        for (int i = 0; i < n / 2; i++) {

            int twinSum =
                    values.get(i) +
                    values.get(n - 1 - i);

            maxTwinSum =
                    Math.max(maxTwinSum, twinSum);
        }

        return maxTwinSum;
    }
}
