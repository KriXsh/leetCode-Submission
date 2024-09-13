class dpOnStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through each price in the array
        for (int i = 0; i < prices.length; i++) {
            // Calculate potential profit
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
        // Update maxProfit if the calculated profit is greater than maxProfit
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        // Return the maximum profit
        return maxProfit;

    }
}