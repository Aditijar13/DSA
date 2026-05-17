
class Solution {

    public boolean canReach(int[] arr, int start) {

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);

        while (!queue.isEmpty()) {

            int currentIndex = queue.poll();

            // Reached value 0
            if (arr[currentIndex] == 0) {
                return true;
            }

            int jumpDistance = arr[currentIndex];

            // Mark as visited
            arr[currentIndex] = -1;

            // Possible next positions
            int forward = currentIndex + jumpDistance;
            int backward = currentIndex - jumpDistance;

            // Forward jump
            if (forward >= 0 &&
                forward < arr.length &&
                arr[forward] >= 0) {

                queue.offer(forward);
            }

            // Backward jump
            if (backward >= 0 &&
                backward < arr.length &&
                arr[backward] >= 0) {

                queue.offer(backward);
            }
        }

        return false;
    }
}
