public class maxAvgSubarray643 {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first k elements
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        // Initialize maxSum as the sum of the first window
        double maxSum = currentSum;
        
        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Update the sum by subtracting the element that's leaving the window
            // and adding the new element that's entering the window
            currentSum = currentSum - nums[i - k] + nums[i];
            // Update maxSum if the currentSum is larger
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        // Return the maximum average
        return maxSum / k;
    }
}
