/*
 * LeetCode 238 - Product of Array Except Self
 *
 * Problem:
 * Given an integer array nums, return an array answer such that
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Constraints:
 * - Must run in O(n) time
 * - Cannot use division
 * - Extra space should be O(1) (output array does not count)
 *
 * Approach:
 * We compute:
 * 1) Prefix product (product of elements to the left of i)
 * 2) Suffix product (product of elements to the right of i)
 *
 * Instead of using two extra arrays, we reuse the output array
 * to maintain O(1) extra space.
 */

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // This array will store the final result.
        // answer[i] will contain:
        // (product of elements to the left of i) * (product of elements to the right of i)
        int[] answer = new int[n];

        /*
         * Step 1: Compute Prefix Products
         *
         * prefix will store the running product of elements
         * to the LEFT of the current index.
         */
        int prefix = 1;

        for (int i = 0; i < n; i++) {

            // Store product of all elements before index i
            answer[i] = prefix;

            // Update prefix by multiplying current element
            prefix *= nums[i];
        }

        /*
         * Step 2: Compute Suffix Products
         *
         * suffix will store the running product of elements
         * to the RIGHT of the current index.
         *
         * We multiply the existing prefix value in answer[i]
         * with the suffix product to get final result.
         */
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            // Multiply with product of elements after index i
            answer[i] *= suffix;

            // Update suffix by multiplying current element
            suffix *= nums[i];
        }

        return answer;
    }
}
