class Solution {

    /*
     * Problem:
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     *
     * Idea / Prompt:
     * - Any integer can be uniquely represented by its prime factors.
     * - If a number has only 2, 3, and 5 as prime factors,
     *   repeatedly dividing it by these values should finally reduce it to 1.
     * - If any other prime factor exists (like 7, 11, etc.),
     *   it will remain even after removing all 2s, 3s, and 5s.
     */

    public boolean isUgly(int n) {

        // Prompt 1:
        // Ugly numbers must be positive.
        // Negative numbers and 0 cannot have valid prime factorization.
        if (n <= 0) return false;

        // Prompt 2:
        // Remove all factors of 2 (allowed prime factor)
        while (n % 2 == 0) {
            n /= 2;
        }

        // Prompt 3:
        // Remove all factors of 3 (allowed prime factor)
        while (n % 3 == 0) {
            n /= 3;
        }

        // Prompt 4:
        // Remove all factors of 5 (allowed prime factor)
        while (n % 5 == 0) {
            n /= 5;
        }

        // Prompt 5:
        // After removing all allowed prime factors:
        // - If n becomes 1, the number had no other prime factors.
        // - If n is greater than 1, some other prime factor exists.
        return n == 1;
    }
}
