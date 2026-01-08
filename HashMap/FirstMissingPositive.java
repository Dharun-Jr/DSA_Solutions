import java.util.HashMap;

class Solution {

    /*
     * Approach:
     * ---------
     * 1. Store all elements of the array in a HashMap.
     * 2. Starting from 1, check which positive number is missing first.
     *
     * This works because HashMap allows O(1) average-time lookups.
     */

    public int firstMissingPositive(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store all numbers in the HashMap
        for (int num : nums) {
            map.put(num, 1);
        }

        /*
         * The smallest missing positive number must be in the range [1, n + 1],
         * where n is the length of the array.
         */
        for (int ctr = 1; ctr <= nums.length + 1; ctr++) {
            if (!map.containsKey(ctr)) {
                return ctr;
            }
        }

        return -1; // fallback (never reached)
    }
}
