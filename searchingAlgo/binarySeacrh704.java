class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // pointer approch 
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

//recursive approch

class Solution2 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    //recursive approch
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid; // Target found
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right); 
            // Search in the right half
        } else {
            return binarySearch(nums, target, left, mid - 1);
            // Search in the left half
        }
    }
}
