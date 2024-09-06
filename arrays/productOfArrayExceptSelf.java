class productOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: Initialize the first element of result as 1
        result[0] = 1;
        
        // Step 2: Calculate prefix products directly into result
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Step 3: Calculate suffix products on the fly and update result array
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return result;
    }
}
