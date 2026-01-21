import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Generates the FizzBuzz sequence from 1 to n.
     *
     * Rules:
     * - If a number is divisible by both 3 and 5 → "FizzBuzz"
     * - If divisible only by 3 → "Fizz"
     * - If divisible only by 5 → "Buzz"
     * - Otherwise → the number itself (as a String)
     *
     * @param n the upper limit of the sequence
     * @return a List of Strings representing the FizzBuzz sequence
     */
    public List<String> fizzBuzz(int n) {

        // Create a list to store the result
        List<String> list = new ArrayList<>();

        // Iterate from 1 to n (inclusive)
        for (int i = 1; i <= n; i++) {

            // Check if the number is divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }
            // Check if the number is divisible only by 3
            else if (i % 3 == 0) {
                list.add("Fizz");
            }
            // Check if the number is divisible only by 5
            else if (i % 5 == 0) {
                list.add("Buzz");
            }
            // If none of the above, add the number itself as a String
            else {
                list.add(String.valueOf(i));
            }
        }

        // Return the final FizzBuzz list
        return list;
    }
}
