
class Solution {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Find pivot index
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivot = left;

        // Search in left sorted half
        int result = binarySearch(
                nums,
                target,
                0,
                pivot - 1
        );

        if (result != -1) {
            return result;
        }

        // Search in right sorted half
        return binarySearch(
                nums,
                target,
                pivot,
                nums.length - 1
        );
    }

    private int binarySearch(
            int[] nums,
            int target,
            int left,
            int right
    ) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
