class sortedCheck {
    public static void main(String[] args) {
       int[] arr = {1,3,4,5,6,7,8,8};
       System.out.println(checkSorted(arr, 0));
    }
     // If we have reached the last element, the array is sorted
    static boolean checkSorted(int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }
        // Check if the current element is less than or equal to the next and continue
        return arr[index] <= arr[index+1] && checkSorted(arr, index+1);
    }
}