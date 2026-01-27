class Solution {

    // Function to check if the array contains any duplicate element
    public boolean containsDuplicate(int[] nums) {

        // HashSet is used because it stores only unique values
        // and provides O(1) average time for add() and contains()
        HashSet<Integer> set = new HashSet<>();

        // Traverse each number in the array
        for(int num : nums){

            // If number already exists in the set,
            // it means we have seen it before → duplicate found
            if(set.contains(num)){
                return true;  // Duplicate detected
            }

            // If not present, store the number in the set
            set.add(num);
        }

        // If loop completes, no duplicates were found
        return false;
    }
}
