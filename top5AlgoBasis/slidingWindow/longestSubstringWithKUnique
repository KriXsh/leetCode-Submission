// problem LINK-  https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
/*
Find the longest substring with k unique characters in a given string
Last Updated : 24 Apr, 2023
Given a string you need to print longest possible substring that has exactly M unique characters. If there is more than one substring of longest possible length, then print any one of them.

Examples: 


Input: Str = “aabbcc”, k = 1
Output: 2
Explanation: Max substring can be any one from {“aa” , “bb” , “cc”}.


Input: Str = “aabbcc”, k = 2
Output: 4
Explanation: Max substring can be any one from {“aabb” , “bbcc”}.


Input: Str = “aabbcc”, k = 3
Output: 6
Explanation: 
There are substrings with exactly 3 unique characters
{“aabbcc” , “abbcc” , “aabbc” , “abbc” }
Max is “aabbcc” with length 6.


Input: Str = “aaabbb”, k = 3
Output: Not enough unique characters
Explanation: There are only two unique characters, thus show error message. 
*/



// Import required libraries for input-output and utility classes
import java.io.*;
import java.util.*;

class GFG {
    // Function to find the length of the longest substring with exactly k unique characters
    public static int longestkSubstr(String S, int k) {
        // HashMap to store the frequency of characters in the current window
        Map<Character, Integer> map = new HashMap<>();

        // Initialize two pointers for the sliding window
        int i = -1; // 'i' represents the right end of the window
        int j = -1; // 'j' represents the left end of the window
        
        int ans = -1; // Variable to store the maximum length of the valid substring
        
        // Infinite loop to expand and shrink the window
        while (true) { 
            boolean flag1 = false; // Flag to track if the first while loop runs
            boolean flag2 = false; // Flag to track if the second while loop runs
            
            // First while loop: Expand the window to the right
            while (i < S.length() - 1) { 
                flag1 = true; // Set flag1 to true as this loop runs
                i++; // Move the right pointer forward
                char ch = S.charAt(i); // Get the current character
                
                // Update the frequency of the character in the map
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // If the current window has fewer than k unique characters, continue expanding
                if (map.size() < k)
                    continue;

                // If the current window has exactly k unique characters, update the answer
                else if (map.size() == k) {
                    int len = i - j; // Calculate the length of the current window
                    ans = Math.max(len, ans); // Update the maximum length
                }

                // If the current window has more than k unique characters, stop expanding
                else
                    break;
            }

            // Second while loop: Shrink the window from the left
            while (j < i) {
                flag2 = true; // Set flag2 to true as this loop runs
                j++; // Move the left pointer forward
                char ch = S.charAt(j); // Get the current character to shrink from the left

                // Reduce the frequency of the character in the map
                if (map.get(ch) == 1)
                    map.remove(ch); // If frequency becomes zero, remove the character
                else
                    map.put(ch, map.get(ch) - 1); // Otherwise, decrement the frequency

                // If the current window has exactly k unique characters, update the answer
                if (map.size() == k) {
                    int len = i - j; // Calculate the length of the current window
                    ans = Math.max(ans, len); // Update the maximum length
                    break; // Exit the loop as we now have a valid window
                }

                // If the current window still has more than k unique characters, keep shrinking
                else if (map.size() > k)
                    continue;
            }

            // If neither loop runs, break out of the infinite loop
            if (flag1 == false && flag2 == false)
                break;
        }

        return ans; // Return the length of the longest substring with k unique characters
    }

    public static void main(String[] args) {
        String s = "aabacbebebe"; // Input string
        int k = 3; // Number of unique characters

        // Call the function and store the result
        int ans = longestkSubstr(s, k);

        // Print the result
        System.out.println(ans);
    }
}
