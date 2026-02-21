import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        // Edge case: if array is empty, answer is 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Store all numbers in a HashSet
        // HashSet gives O(1) average time complexity for contains()
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);   // duplicates automatically removed
        }

        int longest = 0;   // stores maximum sequence length found

        // Step 2: Iterate through the set (not the original array)
        for (int num : set) {

            // Step 3: Check if current number is the START of a sequence
            // A number is start only if (num - 1) is NOT present
            if (!set.contains(num - 1)) {

                int currentNum = num;   // start of sequence
                int currentLength = 1;  // count current number itself

                // Step 4: Expand forward while next consecutive number exists
                while (set.contains(currentNum + 1)) {
                    currentNum++;       // move to next number
                    currentLength++;    // increase sequence length
                }

                // Step 5: Update global maximum
                longest = Math.max(longest, currentLength);
            }
        }

        // Return the longest consecutive sequence length
        return longest;
    }
}
