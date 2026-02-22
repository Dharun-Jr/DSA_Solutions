import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {

        // Map to store:
        // key   -> prefix sum value
        // value -> frequency of that prefix sum
        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        // Base case:
        // Prefix sum 0 occurs once before we start.
        // This helps count subarrays that start from index 0.
        prefixMap.put(0, 1);

        int prefixSum = 0;   // Running cumulative sum
        int count = 0;       // Total number of valid subarrays

        // Traverse the array once (O(n))
        for (int num : nums) {

            // Step 1: Update prefix sum
            prefixSum += num;

            /*
             Step 2:
             If (prefixSum - k) has appeared before,
             then there exists a previous prefix such that:

                 prefixSum - previousPrefix = k

             Which means:
                 Subarray between them has sum = k
            */
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            /*
             Step 3:
             Store/update current prefix sum frequency.
             We do this AFTER checking,
             so we only use prefixes from earlier indices.
            */
            prefixMap.put(
                prefixSum,
                prefixMap.getOrDefault(prefixSum, 0) + 1
            );
        }

        // Final count of subarrays whose sum = k
        return count;
    }
}
