// probelm link - https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // DP array: dp[i] contains all combinations that sum up to i
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        // Initialize the dp array
        for(int i = 0; i <= target; i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>()); // Base case: only one way to get sum = 0 (empty list)
        // Process each candidate
        for(int num : candidates){
            for(int j = num; j <= target; j++){
                // For all combinations that sum up to (j - num), add 'num' to those combinations
                for (List<Integer> combination : dp[j - num]){
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.add(num);
                    dp[j].add(newCombination);

                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        // Test case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Output: " + solution.combinationSum(candidates1, target1));
    }
}