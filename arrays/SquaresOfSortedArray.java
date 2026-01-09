class Solution {
    public int[] sortedSquares(int[] nums) {

        // Length of the input array
        int len = nums.length;

        // Result array to store sorted squares
        int[] res = new int[len];

        // Two pointers:
        // left  -> start of array (smallest value, possibly negative)
        // right -> end of array (largest value)
        int left = 0;
        int right = len - 1;

        // Position to fill in result array (from end to start)
        int pos = len - 1;

        // Continue until both pointers cross
        while (left <= right) {

            // Square of left and right elements
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            // Compare squared values
            // Larger square should be placed at current 'pos'
            if (l > r) {
                res[pos] = l;   // place larger square
                left++;         // move left pointer forward
            } else {
                res[pos] = r;   // place larger square
                right--;        // move right pointer backward
            }

            // Move to next position in result array
            pos--;
        }

        // Return the sorted squares array
        return res;
    }
}
