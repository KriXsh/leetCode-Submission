public class FindtTheSecondElement {
    public static int[] getSecondOrderElements(int n, int[] a) {
        // Edge case: if n < 2, it is impossible to find second largest and smallest
        if (n < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements.");
        }
        
        // Initialize the variables
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        // Single pass through the array
        for (int i = 0; i < n; i++) {
            // Update largest and second largest
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest) {
                secondLargest = a[i];
            }
            
            // Update smallest and second smallest
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
        }

        return new int[]{secondLargest, secondSmallest};
    }
    
    public static void main(String[] args) {
        // Example usage
        int n = 5;
        int[] a = {4, 5, 3, 6, 7};
        int[] result = getSecondOrderElements(n, a);
        System.out.println("Second Largest: " + result[0] + ", Second Smallest: " + result[1]);
    }
}
