class findFirstAndLastElement {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target);

        // If the target doesn't exist in the array, return [-1, -1]
        if (first == nums.length || nums[first] != target) {
            return new int[] { -1, -1 };
        }

        return new int[] { first, last - 1 }; // last - 1 gives us the last occurrence
    }

    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Lower bound index where target should be inserted
    }

    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Upper bound index where element greater than target is found
    }
}
