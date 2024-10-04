// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//use to perform linear search

class linearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 45, 4, 6, 78, 8, 21, 43 };
        int target = 43;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearchIndex(arr, target, 0));

    }
    
    static boolean linearSearch(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || linearSearch(arr, target, index + 1);
    }

    static int linearSearchIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return linearSearchIndex(arr, target, index + 1);
    }
}