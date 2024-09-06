class reverseSentances151 {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        // Split the string into words by any whitespace
        String[] words = s.split("\\s+");
        // Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();

    }
}