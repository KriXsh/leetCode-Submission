// code sudio
public class removeDuplicatesArray {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        int i =0;
        for(int j=1; j<n; j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i +1;
    }
}


// leet code

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int j=1;
        for(int i= 0; i< nums.length-1 ;i++){
            if(nums[i]!=nums[i+1]) {
                nums[j++]=nums[i+1];
        }
      }
      return j;
    }
}