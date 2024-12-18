// probelm link - https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res; // To store all valid combinations
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates); // Optional: Sorting helps in early termination of the loop
        
        backtrack(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    
    private void backtrack(int index, List<Integer> current, int currentSum, int[] candidates, int target) {
        // Base case: If the current sum equals the target, add the combination
        if (currentSum == target) {
            res.add(new ArrayList<>(current)); // Add a copy of the current list
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            // If adding the current candidate exceeds the target, stop exploring further
            if (currentSum + candidates[i] > target) {
                break;
            }
            
            // Choose the current candidate
            current.add(candidates[i]);
            
            // Recurse with the updated current sum and the same index (allow reuse of the same candidate)
            backtrack(i, current, currentSum + candidates[i], candidates, target);
            
            // Undo the choice (backtrack) for exploring other possibilities
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Output: " + solution.combinationSum(candidates1, target1));
        
        // Test case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Output: " + solution.combinationSum(candidates2, target2));
        
        // Test case 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Output: " + solution.combinationSum(candidates3, target3));
    }
}
