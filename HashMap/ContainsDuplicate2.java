import java.util.HashMap;

class Solution {

    /**
     * Checks whether the array contains two equal elements
     * such that the difference between their indices is at most k.
     *
     * @param nums The input integer array
     * @param k Maximum allowed index distance between duplicate elements
     * @return true if such duplicates exist, otherwise false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // HashMap to store number -> last index where it appeared
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {

            // If number already exists in map, it means we've seen it before
            if (map.containsKey(nums[i])) {

                // Get the previous index of the same number
                int previousIndex = map.get(nums[i]);

                // Check if the difference between indices is within k
                if (i - previousIndex <= k) {
                    return true; // Condition satisfied
                }
            }

            // Update the map with the current index
            // (Always update because we want the closest index for future checks)
            map.put(nums[i], i);
        }

        // No nearby duplicates found
        return false;
    }
}
