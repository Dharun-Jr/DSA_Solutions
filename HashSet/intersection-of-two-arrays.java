import java.util.HashSet;

/*
 * Problem:
 * Given two integer arrays nums1 and nums2,
 * return an array of their intersection.
 * Each element in the result must be unique.
 * Order of result does not matter.
 *
 * Approach:
 * 1. Store all elements of nums1 in a HashSet.
 * 2. Traverse nums2 and check if element exists in set1.
 * 3. If yes, store it in another HashSet (to avoid duplicates).
 * 4. Convert the result set to an int array and return.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        // Step 1: Store elements of nums1
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        // Step 2: Store common elements (unique)
        HashSet<Integer> resultSet = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }

        // Step 3: Convert HashSet to int[]
        int[] result = new int[resultSet.size()];
        int index = 0;

        for (int n : resultSet) {
            result[index++] = n;
        }

        return result;
    }
}
