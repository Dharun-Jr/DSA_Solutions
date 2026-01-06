class Solution {

    public int[] shuffle(int[] nums, int n) {

        // Create a new array of size 2n to store the result
        // Example: nums = [x1,x2,...,xn,y1,y2,...,yn]
        // Output should be [x1,y1,x2,y2,...,xn,yn]
        int[] arr = new int[n * 2];

        // j will be used to fill positions in the new array (arr)
        int j = 0;

        // Loop runs only for first n elements (x values)
        for (int i = 0; i < n; i++) {

            // Place x(i) element at even index of result
            arr[j] = nums[i];

            // Place y(i) element at next odd index of result
            // nums[i + n] picks the corresponding element from second half
            arr[j + 1] = nums[i + n];

            // Move j by 2 positions for next pair
            j += 2;
        }

        // Return the shuffled array
        return arr;
    }
}
