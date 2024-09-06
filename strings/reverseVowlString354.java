import java.util.*;
import java.util.HashSet;

class reverseVowlString354 {
    public String reverseVowels(String s) {
        // Convert the string to a char array for in-place modification
        char[] chars = s.toCharArray();
        // Set of vowels for quick lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move the left pointer to the next vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move the right pointer to the previous vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            // Swap the vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        // Convert the char array back to a string
        return new String(chars);
    }
}
