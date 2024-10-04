// Online Java Compiler
// Use this editor to write, compile and run your Java code online
//use to perform linear search
import java.util.ArrayList;

class linearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 45, 4, 6, 78, 8, 21, 43 };
        int target = 43;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearchIndex(arr, target, 0));
        System.out.println(linearSearchArrayList(arr, target, 0, new ArrayList<>()));

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
    static ArrayList<Integer>linearSearchArrayList (int[] arr, int target, int index, ArrayList<Integer>list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return linearSearchArrayList( arr, target, index+1,list);
    }

}