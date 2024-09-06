//leetcode

class countbits338 {
    public int[] countBits(int n) {
        // Create an array to store the result
        int[] ans = new int[n + 1];
        // Iterate from 1 to n (inclusive)
        for (int i = 1; i <= n; i++) {
            // Use the formula to calculate the number of 1's
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans; // Return the result array
    }
}
