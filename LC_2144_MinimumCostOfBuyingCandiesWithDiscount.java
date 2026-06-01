

import java.util.Arrays;

class Solution {

    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int totalCost = 0;

        for (int i = cost.length - 1; i >= 0; i -= 3) {

            // Most expensive candy
            totalCost += cost[i];

            // Second most expensive candy
            if (i > 0) {
                totalCost += cost[i - 1];
            }

            // Third candy is free
        }

        return totalCost;
    }
}
