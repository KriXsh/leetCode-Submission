import java.util.Scanner ;
// import java.io.*; 


// leetcode 

class rotateTheArrayByK {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// code studio roate by 1 

public class rotateTheArrayByK189 {

    static int[] rotateArray(int[] arr, int n) {
        // Store the first element
        int temp = arr[0];
        
        // Shift elements to the left
        for(int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        
        // Place the first element at the last position
        arr[n - 1] = temp;
        
        return arr; // Return the modified array
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Rotating array
        int[] result = rotateArray(arr, n);
        
        // Output the rotated array
        for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}


