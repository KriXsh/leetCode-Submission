//2461. Maximum Sum of Distinct Subarrays With Length K
//link - https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/


import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long cs = 0; // Current sum
        int begin = 0; // Window start
        int end = 0; // Window end
        Map<Integer, Integer> lastSeen = new HashMap<>();
        
        while (end < nums.length) {
            int curr = nums[end];
            int j = lastSeen.getOrDefault(curr, -1); // Last seen index of current element
            
            // Discard elements from the beginning to ensure distinct elements and window size
            while (j >= begin || (end - begin + 1) > k) {
                cs -= nums[begin++];
            }
            
            // Add current element to the sum and update its last seen index
            cs += nums[end];
            lastSeen.put(curr, end);
            
            // Update the answer if window size is exactly k
            if (end - begin + 1 == k) {
                ans = Math.max(ans, cs);
            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        
        long result = solution.maximumSubarraySum(nums, k);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}
