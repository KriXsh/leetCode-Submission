public class movesZeors283 {
    public void moveZeroes(int[] nums) {
        int j = -1;
        int n = nums.length;

        // Find the index of the first zero element
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero element found, return
        if (j == -1)
            return;

        // Move non-zero elements after the first zero element
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}
