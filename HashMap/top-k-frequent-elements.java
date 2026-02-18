import java.util.*;

/*
 * Problem:
 * Given an integer array nums and an integer k,
 * return the k most frequent elements.
 *
 * Approach:
 * 1. Count frequencies using HashMap.
 * 2. Use Bucket Sort technique where index = frequency.
 * 3. Traverse buckets from high frequency to low.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // ----------------------------
        // Step 1: Count frequencies
        // ----------------------------
        // Key   -> number from array
        // Value -> frequency of that number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            // If num already exists, increment its frequency
            // Otherwise, start from 0 and add 1
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // -------------------------------------------
        // Step 2: Create bucket array
        // -------------------------------------------
        // Index represents frequency.
        // bucket[i] will store all numbers that appear i times.
        // Maximum possible frequency = nums.length
        List<Integer>[] bucket = new List[nums.length + 1];

        // Place each number into its corresponding frequency bucket
        for (int key : frequencyMap.keySet()) {

            int freq = frequencyMap.get(key);

            // Initialize list if it doesn't exist
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            // Add number to the bucket matching its frequency
            bucket[freq].add(key);
        }

        // -------------------------------------------
        // Step 3: Collect top k frequent elements
        // -------------------------------------------
        int[] result = new int[k];
        int index = 0;  // Tracks how many elements we've added to result

        // Traverse from highest frequency to lowest
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {  // If some numbers have this frequency

                for (int num : bucket[i]) {

                    result[index++] = num;  // Store number and increment index

                    // Stop once we've collected k elements
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
