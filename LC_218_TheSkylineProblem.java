
class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        // Store all unique x-coordinates
        Set<Integer> uniquePositions = new TreeSet<>();

        for (int[] building : buildings) {
            uniquePositions.add(building[0]); // left edge
            uniquePositions.add(building[1]); // right edge
        }

        // Coordinate compression mapping
        Map<Integer, Integer> positionToIndex = new HashMap<>();

        int index = 0;

        for (int position : uniquePositions) {
            positionToIndex.put(position, index++);
        }

        // Stores maximum height for every segment
        int[] maxHeights = new int[positionToIndex.size()];

        // Fill heights
        for (int[] building : buildings) {

            int leftIndex = positionToIndex.get(building[0]);
            int rightIndex = positionToIndex.get(building[1]);
            int height = building[2];

            for (int i = leftIndex; i < rightIndex; i++) {
                maxHeights[i] =
                    Math.max(maxHeights[i], height);
            }
        }

        // Sorted positions list
        List<Integer> sortedPositions =
            new ArrayList<>(uniquePositions);

        List<List<Integer>> skyline = new ArrayList<>();

        int previousHeight = 0;

        // Build skyline
        for (int i = 0; i < maxHeights.length; i++) {

            if (maxHeights[i] != previousHeight) {

                skyline.add(Arrays.asList(
                    sortedPositions.get(i),
                    maxHeights[i]
                ));

                previousHeight = maxHeights[i];
            }
        }

        // Add final ground point
        if (previousHeight != 0) {

            skyline.add(Arrays.asList(
                sortedPositions.get(
                    sortedPositions.size() - 1
                ),
                0
            ));
        }

        return skyline;
    }
}
