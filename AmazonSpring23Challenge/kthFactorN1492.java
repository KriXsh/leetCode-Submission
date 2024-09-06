import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class kthFactorN1492 {
    public int kthFactor(int n, int k) {
         ArrayList<Integer> factors = new ArrayList<>();
        
        // Iterate over possible factors from 1 to sqrt(n)
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        
        // Sort the factors list
        Collections.sort(factors);
        
        // Check if k is within the number of factors found
        if (k <= factors.size()) {
            return factors.get(k - 1);
        } else {
            return -1;
        }
        
    }
}


class Solution2 {
    public int kthFactor(int n, int k) {
        // list approch
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) { // Add the complementary factor
                    factors.add(n / i);
                }
            }
        }
        Collections.sort(factors); // Sorting the factors to get them in order
        return factors.size() < k ? -1 : factors.get(k - 1);

    }
}