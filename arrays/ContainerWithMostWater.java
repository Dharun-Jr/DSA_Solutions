class Solution {

    // Function to find the maximum amount of water that can be stored
    public int maxArea(int[] height) {

        // Pointer at the beginning of the array
        int start = 0;

        // Pointer at the end of the array
        int end = height.length - 1;

        // Variable to store the maximum area found
        int area = 0;

        // Continue until the two pointers meet
        while (start < end) {

            // Height of container is limited by the shorter wall
            int h = Math.min(height[start], height[end]);

            // Width is the distance between the two pointers
            int w = end - start;

            // Calculate area and update maximum if needed
            area = Math.max(area, h * w);

            /*
             Move the pointer pointing to the shorter wall.
             WHY?
             Because area depends on the smaller height.
             Moving the taller wall will never increase area.
            */
            if (height[start] < height[end]) {
                start++;  // Move left pointer right
            } else {
                end--;    // Move right pointer left
            }
        }

        // Return the maximum water that can be stored
        return area;
    }
}
