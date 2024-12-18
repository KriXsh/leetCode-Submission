import java.util.Arrays;

class Main {
    public int coinChange(int[] coins, int amount) {
        // Create DP array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize DP array with a large value
        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        // Iterate over all amounts from 1 to 'amount'
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If the value at dp[amount] is still the large value, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount)); // Output: 3
    }
}
