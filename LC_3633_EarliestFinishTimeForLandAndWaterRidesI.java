/*
 * Problem: Earliest Finish Time for Land and Water Rides I
 * Platform: LeetCode
 * Problem Number: 3633
 *
 * Approach:
 * - Try both possible orders:
 *      1. Land Ride -> Water Ride
 *      2. Water Ride -> Land Ride
 *
 * - For a given order:
 *      a) Find the earliest completion time among all rides
 *         of the first type.
 *      b) For each ride of the second type:
 *           start = max(firstCompletionTime, secondStartTime)
 *           finish = start + secondDuration
 *      c) Take the minimum finish time.
 *
 * - Return the minimum answer from both orders.
 *
 * Time Complexity: O(n + m)
 *      n = number of land rides
 *      m = number of water rides
 *
 * Space Complexity: O(1)
 */
class Solution {
    public int earliestFinishTime(
        int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int landThenWaterTime = calculateSequentialFinishTime(
            landStartTime, landDuration, waterStartTime, waterDuration);

        int waterThenLandTime = calculateSequentialFinishTime(
            waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(landThenWaterTime, waterThenLandTime);
    }

    private int calculateSequentialFinishTime(
        int[] firstStartTimes, int[] firstDurations,
        int[] secondStartTimes, int[] secondDurations) {

        int earliestFirstTaskCompletion = Integer.MAX_VALUE;
        for (int i = 0; i < firstStartTimes.length; i++) {
            int taskEndTime = firstStartTimes[i] + firstDurations[i];
            earliestFirstTaskCompletion = Math.min(earliestFirstTaskCompletion, taskEndTime);
        }

        int earliestTotalCompletion = Integer.MAX_VALUE;
        for (int i = 0; i < secondStartTimes.length; i++) {
            int actualSecondTaskStart = Math.max(earliestFirstTaskCompletion, secondStartTimes[i]);
            int totalCompletionTime = actualSecondTaskStart + secondDurations[i];
            earliestTotalCompletion = Math.min(earliestTotalCompletion, totalCompletionTime);
        }

        return earliestTotalCompletion;
    }
}
