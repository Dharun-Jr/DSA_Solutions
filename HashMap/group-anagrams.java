/*
 Approach: Sorting Characters

 Idea:
 Two strings are anagrams if their sorted forms are the same.
 Example: "eat", "tea", "ate" → sorted → "aet"

 Time Complexity: O(N * K log K)
 Space Complexity: O(N * K)
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Map: sorted string → list of original anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to char array so we can sort it
            char[] chars = str.toCharArray();

            // Sort characters alphabetically
            Arrays.sort(chars);

            // Create string from sorted characters (anagram signature)
            String key = new String(chars);

            // If key not present, create new group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
/*
 Approach: Character Frequency Counting

 Idea:
 Two strings are anagrams if the count of each letter (a–z) is the same.
 Instead of sorting, we count letters and build a signature.

 Time Complexity: O(N * K)
 Space Complexity: O(N * K)
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Map: frequency signature → list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Array to count letters a–z
            int[] freq = new int[26];

            // Count each character
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;  // 'a' → 0, 'b' → 1, ... 'z' → 25
            }

            // Build unique key from frequency array
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append(count).append('#');  // separator avoids collision
            }

            String key = keyBuilder.toString();

            // Add string to its anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}
