/*
Problem: Earliest Finish Time for Land and Water Rides II
Platform: LeetCode 3665

Approach:
1. Consider both possible ride orders:
   - Land -> Water
   - Water -> Land
2. For a fixed order:
   - Find the earliest finishing ride from the first category.
   - Try every ride from the second category.
   - The second ride can start only after:
       a) the first ride finishes
       b) the second ride becomes available
   - Start time = max(firstRideEnd, secondRideStartTime)
3. Compute the minimum finish time among all valid second rides.
4. Return the minimum answer from both orders.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/
class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {

        int landThenWater = calculateFinishTime(
            landStartTime,
            landDuration,
            waterStartTime,
            waterDuration
        );

        int waterThenLand = calculateFinishTime(
            waterStartTime,
            waterDuration,
            landStartTime,
            landDuration
        );

        return Math.min(landThenWater, waterThenLand);
    }

    private int calculateFinishTime(
        int[] firstStartTimes,
        int[] firstDurations,
        int[] secondStartTimes,
        int[] secondDurations
    ) {

        int earliestFirstCategoryEnd = Integer.MAX_VALUE;

        for (int i = 0; i < firstStartTimes.length; i++) {
            int taskEndTime = firstStartTimes[i] + firstDurations[i];
            earliestFirstCategoryEnd =
                Math.min(earliestFirstCategoryEnd, taskEndTime);
        }

        int minimumTotalTime = Integer.MAX_VALUE;

        for (int i = 0; i < secondStartTimes.length; i++) {

            int secondTaskStart =
                Math.max(earliestFirstCategoryEnd, secondStartTimes[i]);

            int totalTime =
                secondTaskStart + secondDurations[i];

            minimumTotalTime =
                Math.min(minimumTotalTime, totalTime);
        }

        return minimumTotalTime;
    }
}
