import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) { // Overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Non-overlapping intervals
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = merge(intervals1);
        System.out.println("Output: " + Arrays.deepToString(result1)); // Output: [[1,6],[8,10],[15,18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = merge(intervals2);
        System.out.println("Output: " + Arrays.deepToString(result2)); // Output: [[1,5]]
    }
}
