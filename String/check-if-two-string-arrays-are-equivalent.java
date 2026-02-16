class Solution {

    // ------------------------------------------------------------
    // Approach 1: Using StringBuilder
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m) -> extra strings are created
    // ------------------------------------------------------------
    public boolean arrayStringsAreEqual_StringBuilder(String[] word1, String[] word2) {

        // Build the full string from word1
        StringBuilder sb1 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }

        // Build the full string from word2
        StringBuilder sb2 = new StringBuilder();
        for (String s : word2) {
            sb2.append(s);
        }

        // Compare the final strings
        return sb1.toString().equals(sb2.toString());
    }

    // ------------------------------------------------------------
    // Approach 2: Two Pointer / While Loop (Optimized)
    // Time Complexity: O(n + m)
    // Space Complexity: O(1) -> no extra strings
    // ------------------------------------------------------------
    public boolean arrayStringsAreEqual_TwoPointers(String[] word1, String[] word2) {

        int i = 0, j = 0;   // indices for word arrays
        int p = 0, q = 0;   // indices for characters inside each word

        // Traverse both arrays character by character
        while (i < word1.length && j < word2.length) {

            // If characters differ, strings are not equal
            if (word1[i].charAt(p) != word2[j].charAt(q)) {
                return false;
            }

            // Move to next character
            p++;
            q++;

            // If end of current word in word1 is reached
            if (p == word1[i].length()) {
                i++;
                p = 0;
            }

            // If end of current word in word2 is reached
            if (q == word2[j].length()) {
                j++;
                q = 0;
            }
        }

        // Both arrays must be fully traversed
        return i == word1.length && j == word2.length;
    }
}
