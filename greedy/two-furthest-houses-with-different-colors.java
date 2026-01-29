class Solution {
    public int maxDistance(int[] colors) {

        int len = colors.length;
        int max = 0;  // Stores the maximum distance found

        // Case 1: Compare every house with the LAST house
        // We move from left → right and stop at the first house
        // that has a different color than the last house.
        // This gives the maximum possible distance from the end.
        for (int i = 0; i < len; i++) {
            if (colors[i] != colors[len - 1]) {
                max = Math.max(max, len - 1 - i);  // distance from last index
                break;  // No need to check further
            }
        }

        // Case 2: Compare every house with the FIRST house
        // We move from right → left and stop at the first house
        // that has a different color than the first house.
        // This gives the maximum possible distance from the start.
        for (int i = len - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                max = Math.max(max, i);  // distance from index 0
                break;  // No need to check further
            }
        }

        return max;
    }
}
