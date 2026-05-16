

public class Solution {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int minimum = nums[0];

        while (left <= right) {

            // If current portion is already sorted
            if (nums[left] < nums[right]) {
                minimum = Math.min(minimum, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;

            minimum = Math.min(minimum, nums[mid]);

            // Left half is sorted
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            }
            // Right half is sorted
            else {
                right = mid - 1;
            }
        }

        return minimum;
    }
}
