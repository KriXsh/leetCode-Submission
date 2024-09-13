class ReverseArray {
    // Method to reverse the array
    public void getReverseArray(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

public class gotReverseArray2 {
    public static void main(String[] args) {
        int[] result = {3, 5, 2, 5, 7}; // Array to be reversed
        ReverseArray reverseObj = new ReverseArray(); // Create object of ReverseArray class
        
        System.out.println("Original array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
        
        reverseObj.getReverseArray(result, 0, result.length - 1); // Call the method to reverse the array
        
        System.out.println("\nReversed array:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
