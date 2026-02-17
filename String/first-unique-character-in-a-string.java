/*
 * Approach 1: Using Frequency Array
 *
 * Idea:
 * 1. Count frequency of each character using an array.
 * 2. Traverse the string again to find the first character
 *    whose frequency is 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)  (because character range is fixed)
 */

class Solution {
    public int firstUniqChar(String s) {

        // Array size 26 since problem states only lowercase English letters
        int[] freq = new int[26];

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;   // Map 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
        }

        // Step 2: Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // If no unique character found
        return -1;
    }
}
/*
 * Approach 2: Using HashMap
 *
 * Idea:
 * 1. Store frequency of each character using HashMap.
 * 2. Traverse string again and return index of first
 *    character with frequency 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) in worst case
 */

import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
