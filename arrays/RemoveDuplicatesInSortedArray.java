class Solution {
    public int removeDuplicates(int[] nums) {

        // 'back' points to the index of the last unique element found
        int back = 0;

        // 'front' scans the array to find the next unique element
        int front = 1;

        // Traverse the array until the scanning pointer reaches the end
        while (front < nums.length) {

            // If current element is different from the last unique element
            if (nums[back] != nums[front]) {

                // Move 'back' forward to store the new unique element
                back++;

                // Overwrite the duplicate position with the new unique value
                nums[back] = nums[front];
            }

            // Always move the scanning pointer forward
            front++;
        }

        // Number of unique elements is last unique index + 1
        return back + 1;
    }
}
