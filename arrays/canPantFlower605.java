class canPantFlower605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        
        while (i < flowerbed.length) {
            // Check if the current plot is empty
            if (flowerbed[i] == 0) {
                // Check if it's possible to plant a flower here
                // Ensure no adjacent flowers are present
                if ((i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    // Plant the flower
                    flowerbed[i] = 1;
                    count++;
                }
            }
            i++;
        }
        
        // Check if we have planted enough flowers
        return count >= n;
    }
}
