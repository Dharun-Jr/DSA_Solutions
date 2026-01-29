class Solution {
    public int[] replaceElements(int[] arr) {

        // Last index of array
        int len = arr.length - 1;

        // This will store the maximum element seen from the right side
        int max = arr[len];

        // Pointer for the element to the right
        int end = len;

        // Pointer for the current element we need to replace
        int prev = len - 1;

        // Traverse from right to left
        while (prev >= 0) {

            // Store original value before overwriting
            int temp = arr[prev];

            // Replace current element with max element to its right
            arr[prev] = max;

            // Update max if original value was greater
            if (temp > max) {
                max = temp;
            }

            // Move both pointers left
            prev--;
            end--;
        }

        // Last element has no elements to its right
        arr[len] = -1;

        return arr;
    }
}
