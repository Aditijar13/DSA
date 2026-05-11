// Problem: 2553. Separate the Digits in an Array
// Platform: LeetCode
// Approach: Extract Digits + Reverse Order Storage
//
// Idea:
// Traverse each number in nums.
// Extract digits using modulo (%) and division (/).
// Digits come in reverse order, so store temporarily.
// Reverse temporary list and append to final result.
// Convert list into int[] array.
//
// Time Complexity: O(T)
// where T = total number of digits in all numbers
//
// Space Complexity: O(T)

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int number : nums) {
            List<Integer> digits = new ArrayList<>();

            while (number > 0) {
                digits.add(number % 10);
                number /= 10;
            }

            Collections.reverse(digits);
            resultList.addAll(digits);
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
