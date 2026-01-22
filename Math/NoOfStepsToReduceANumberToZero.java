class Solution {

    // This method calculates the number of steps required
    // to reduce a given number to zero.
    public int numberOfSteps(int num) {

        // Create a temporary variable to manipulate the value
        int temp = num;

        // Counter to keep track of total steps performed
        int ctr = 0;

        // Continue until the number becomes zero
        while (temp != 0) {

            // If the number is even, divide it by 2
            if (temp % 2 == 0) {
                temp /= 2;
                ctr++;   // Increment step count
            }
            // If the number is odd, subtract 1
            else {
                temp -= 1;
                ctr++;   // Increment step count
            }
        }

        // Return the total number of steps taken
        return ctr;
    }
}
