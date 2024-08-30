class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Initialize the first and second numbers to a large value
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        // Iterate through the array
        for (int num : nums) {
            if (num <= first) {
                // Update first if num is smaller or equal
                first = num;
            } else if (num <= second) {
        // Update second if num is smaller or equal and greater than first
                second = num;
            } else {
    // If we find a number greater than both first and second, return true
                return true;
            }
        }

        // If no increasing triplet is found, return false
        return false;
    }
}
