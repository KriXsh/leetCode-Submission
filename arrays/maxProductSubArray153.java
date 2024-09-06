class maxProductSubArray153 {
    public int maxProduct(int[] nums) {
        // Edge case: If the array is empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize variables
        int maxProductSoFar = nums[0];
        int minProductSoFar = nums[0];
        int result = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            // Temporary variable to hold the current max product
            int tempMax = Math.max(currentNum, Math.max(maxProductSoFar * currentNum, minProductSoFar * currentNum));
            // Update the min product for current number
            minProductSoFar = Math.min(currentNum, Math.min(maxProductSoFar * currentNum, minProductSoFar * currentNum));

            // Update the max product
            maxProductSoFar = tempMax;

            // Update the global result
            result = Math.max(result, maxProductSoFar);
        }

        return result;
    }
}
