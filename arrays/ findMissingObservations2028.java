import java.util.Arrays;

class findMissingObservations2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        
        // Calculate the total sum of all n + m rolls
        int totalSum = mean * (n + m);
        
        // Calculate the sum of the observed m rolls
        int observedSum = Arrays.stream(rolls).sum();
        
        // Calculate the sum needed for the missing rolls
        int missingSum = totalSum - observedSum;
        
        // Check if the missing sum can be distributed across n rolls
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];  // It's impossible to form such an array
        }
        
        // Initialize the result array with all 1's
        int[] result = new int[n];
        Arrays.fill(result, 1);
        
        // Distribute the remaining missing sum across the result array
        missingSum -= n;  // We already accounted for n "1"s
        
        for (int i = 0; i < n && missingSum > 0; i++) {
            // Add as much as possible to result[i], but not more than 5 (since it's already 1)
            int add = Math.min(5, missingSum);
            result[i] += add;
            missingSum -= add;
        }
        
        return result;
    }
}


