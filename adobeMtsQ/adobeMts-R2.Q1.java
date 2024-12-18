/**
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.


Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
**/



import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Create a map to store the frequency of characters in t
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int required = tFreq.size();
        int formed = 0;

        // Map to track characters in the current window
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            // If the current character satisfies the required frequency, increment formed
            if (tFreq.containsKey(rightChar) && windowFreq.get(rightChar).intValue() == tFreq.get(rightChar).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left as much as possible while it's valid
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // Remove the left character from the window
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // If removing the character breaks the validity of the window, decrement formed
                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++; // Expand the window
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(minWindow("a", "a"));               // Output: "a"
        System.out.println(minWindow("a", "aa"));              // Output: ""
    }
}
