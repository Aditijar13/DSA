/*
 * Problem: Total Waviness of Numbers in Range I
 * Platform: LeetCode
 * Problem Number: 3751
 *
 * Approach:
 * - For every number in the range [num1, num2]:
 *      1. Extract its digits.
 *      2. Count waviness points.
 *
 * - A digit is a waviness point if it is:
 *      a) Greater than both neighboring digits
 *         (local maxima), OR
 *      b) Smaller than both neighboring digits
 *         (local minima).
 *
 * - Sum the waviness of all numbers in the range.
 *
 * Time Complexity: O((num2 - num1 + 1) * d)
 *      d = number of digits (<= 10 for int)
 *
 * Space Complexity: O(d)
 */
class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int x = num1; x <= num2; x++) {
            ans += f(x);
        }
        return ans;
    }

    private int f(int x) {
        int[] nums = new int[20];
        int m = 0;
        while (x > 0) {
            nums[m++] = x % 10;
            x /= 10;
        }
        if (m < 3) {
            return 0;
        }
        int s = 0;
        for (int i = 1; i < m - 1; i++) {
            if ((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                || (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])) {
                s++;
            }
        }
        return s;
    }
}
