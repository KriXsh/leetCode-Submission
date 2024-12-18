// question link -  https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/ 

// approch -
/*
[Approach – 1] Using Sorting
[Approach – 2] Using Quick Sort Partitioning Algorithm:
[Approach – 3] Using Priority Queue(Min-Heap)
*/


import java.util.*;

public class kLargestNumber {

    public static List<Integer> kLargest(int[] arr, int k) {
        // Validate k
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k. Ensure k > 0 and k <= array length.");
        }

        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Traverse the rest of the array
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Extract elements from the heap
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        // Reverse the list for descending order
        res.sort(Collections.reverseOrder());
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50}; // Input array
        int k = 3; // Replace 0 with a valid k (e.g., 3)

        try {
            List<Integer> res = kLargest(arr, k);
            for (int ele : res) {
                System.out.print(ele + " ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
