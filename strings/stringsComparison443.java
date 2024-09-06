class stringsComparison443 {
    public int compress(char[] chars) {
        int write = 0;  // Position to write in the chars array
        int i = 0;  // Position to read in the chars array
        
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            
            // Count the occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            // Write the character to the array
            chars[write++] = currentChar;
            
            // If count is more than 1, write the digits of the count
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        
        return write;
    }
}
