import java.util.HashSet;


class Solution {
    public int partitionString(String s) {
        int partitions = 1; // We need at least one partition
       HashSet<Character> seenChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seenChars.contains(c)) {
                // Start a new partition
                partitions++;
                seenChars.clear();// Clear the set for the new partition
            }
            seenChars.add(c);// Add the character to the current partition's set
        }
        return partitions;

    }
}