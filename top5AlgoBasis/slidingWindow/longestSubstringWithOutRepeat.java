// problem - 3. Longest Substring Without Repeating Characters
//link - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.*;

public class longestSubstringWithOutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and is inside the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                // Move the start pointer to the right of the duplicate character
                start = map.get(currentChar) + 1;
            }

            // Update the map with the current character's index
            map.put(currentChar, end);

            // Update the maximum length of substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}


// set logic 
/*
 
public int lengthOfLongestSubstring(String s) {
    Set<Character> charSet = new HashSet<>(); // To store unique characters
    int maxLength = 0; // Stores the length of the longest substring
    int start = 0; // Left pointer

    // Traverse the string with the right pointer (end)
    for (int end = 0; end < s.length(); end++) {
        char currentChar = s.charAt(end);

        // If character is already in the set, shrink the window
        while (charSet.contains(currentChar)) {
            charSet.remove(s.charAt(start)); // Remove the leftmost character
            start++; // Move the left pointer
        }

        // Add the current character to the set
        charSet.add(currentChar);

        // Update the maximum length
        maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
 */