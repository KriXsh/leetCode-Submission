
//33. Search Element in Rotated Sorted Array 
//@BruteForce approch should be linear search 

//optimal 
//1. indentity check where the whole array is sorted or not 
//2. then apply binary search logic - element the right or left half which is greater than or lesser than requals to target 

public class SearchEleinRotatedSortedArray {
   
        public int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            
            while (start <= end) {
                int mid = start + (end - start) / 2;
                
                // If the target is found at mid
                if (nums[mid] == target) {
                    return mid;
                }
                
                // Determine which side is sorted
                if (nums[start] <= nums[mid]) {
                    // Left half is sorted
                    if (nums[start] <= target && target < nums[mid]) {
                        // Target is in the left half
                        end = mid - 1;
                    } else {
                        // Target is in the right half
                        start = mid + 1;
                    }
                } else {
                    // Right half is sorted
                    if (nums[mid] < target && target <= nums[end]) {
                        // Target is in the right half
                        start = mid + 1;
                    } else {
                        // Target is in the left half
                        end = mid - 1;
                    }
                }
            }
            
            // Target not found
            return -1;
        }
    
}
