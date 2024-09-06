class MaxConsecutiveOnesIII1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxOnes = 0;  // To keep track of the max number of consecutive 1's
        int zerosCount = 0;  // Count the number of 0's in the window

        while (right < nums.length) {
            // If we encounter a zero, increase the zero count
            if (nums[right] == 0) {
                zerosCount++;
            }

            // If zeros in the window exceed k, shrink the window from the left
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;  // Move the left pointer to reduce the window size
            }

// Calculate the length of the current valid window and update the max length
            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;  // Expand the window by moving the right pointer
        }

        return maxOnes;  // Return the max length of consecutive 1's we can get
    }
}


