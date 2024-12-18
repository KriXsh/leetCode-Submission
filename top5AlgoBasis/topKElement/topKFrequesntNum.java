// leetcode question 347. Top K Frequent Elements -
// link -  https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.*;

public class topKFrequesntNum {
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // set the frequencies
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+ 1);
        }
        // Step 2: Use a Min-Heap to store the top k frequent elements
        PriorityQueue<Map.Entry<Integer ,Integer>> minHeap = new PriorityQueue<>(
        // Sort by frequency in ascending order   
        (a,b) -> a.getValue() - b.getValue()
        );
        //entry on the heap 
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();  // Remove the element with the smallest frequency
            }
        }
        // Step 3: Extract the k most frequent elements from the heap
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Find the top k frequent elements
        int[] result = topKFrequent(nums, k);

        // Print the result
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
    }

}
