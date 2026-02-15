class Solution {
    public boolean check(int[] nums) {

        // ctr counts how many times the sorted order is violated
        int ctr = 0;

        // Check for drops inside the array
        // A drop happens when a previous element is greater than the next one
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                ctr++;
            }
        }

        // Since the array is considered circular after rotation,
        // we must also compare the last element with the first element
        // This detects a drop at the rotation boundary
        if (nums[nums.length - 1] > nums[0]) {
            ctr++;
        }

        // A valid rotated sorted array can have at most one drop
        return ctr <= 1;
    }
}
