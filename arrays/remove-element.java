class Solution {
    public int removeElement(int[] nums, int val) {

        int start = 0;                 // Pointer to scan elements from the beginning
        int end = nums.length - 1;     // Pointer marking the end of the valid region

        /*
         We process elements while start is within the current valid boundary.
         The region from 0 to 'end' (inclusive) is considered valid.
         Anything beyond 'end' is ignored (trash zone).
        */
        while (start <= end) {

            /*
             If current element equals 'val', we "remove" it by replacing it
             with the last valid element in the array.
             This avoids shifting elements and keeps time complexity O(n).
            */
            if (nums[start] == val) {
                nums[start] = nums[end];  // Overwrite with last valid element
                end--;                   // Shrink valid region from the right

                /*
                 We do NOT increment 'start' here because the swapped element
                 needs to be checked — it might also be equal to 'val'.
                */
            } else {
                // Current element is valid, move to the next position
                start++;
            }
        }

        /*
         At the end, 'end + 1' gives the count of elements not equal to 'val'.
         The first (end + 1) positions contain the valid elements.
        */
        return end + 1;
    }
}
