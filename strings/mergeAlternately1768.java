class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        int i = 0, j = 0;
        int len1 = word1.length();
        int len2 = word2.length();

        // Merge characters alternately from both strings
        while (i < len1 && j < len2) {
            merged.append(word1.charAt(i++)); // Add character from word1
            merged.append(word2.charAt(j++)); // Add character from word2
        }

        // If there are remaining characters in word1
        while (i < len1) {
            merged.append(word1.charAt(i++));
        }

        // If there are remaining characters in word2
        while (j < len2) {
            merged.append(word2.charAt(j++));
        }

        return merged.toString(); // Convert StringBuilder to String and return

    }
}