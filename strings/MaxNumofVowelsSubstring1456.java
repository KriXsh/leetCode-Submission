import java.util.*;

public class MaxNumofVowelsSubstring1456 {
        public int maxVowels(String s, int k) {
            // Set to store vowels for quick lookup
            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            
            int maxVowelCount = 0;
            int currentVowelCount = 0;
            
            // First window of size k
            for (int i = 0; i < k; i++) {
                if (vowels.contains(s.charAt(i))) {
                    currentVowelCount++;
                }
            }
            
            // Set the initial max count to the count of vowels in the first window
            maxVowelCount = currentVowelCount;
            
            // Sliding window: move the window one step at a time
            for (int i = k; i < s.length(); i++) {
                // Add the new character (i-th) into the window
                if (vowels.contains(s.charAt(i))) {
                    currentVowelCount++;
                }
                // Remove the character that goes out of the window (i-k-th)
                if (vowels.contains(s.charAt(i - k))) {
                    currentVowelCount--;
                }
                
                // Update the maximum vowel count found so far
                maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
            }
            
            return maxVowelCount;
        }
}

