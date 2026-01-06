import java.util.*;

public class MinRemoveParentheses {

    /**
     * Removes the minimum number of parentheses to make the string valid.
     * A valid string is one where every '(' has a matching ')'
     * and the order of characters remains unchanged.
     *
     * Approach:
     *  - Use a stack to store indexes of unmatched '('
     *  - Mark invalid ')' when there is no matching '('
     *  - After scanning, remaining '(' in stack are also invalid
     *  - Build a new string skipping all invalid characters
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public String minRemoveToMakeValid(String s) {

        // Stack stores indexes of '(' that are not yet matched
        Stack<Integer> stack = new Stack<>();

        // Boolean array marks characters that must be removed
        boolean[] remove = new boolean[s.length()];

        // Pass 1 — Identify invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If it's an opening bracket, store its index
            if (ch == '(') {
                stack.push(i);
            }
            // If it's a closing bracket
            else if (ch == ')') {

                // If stack is empty → no matching '('
                // so this ')' is invalid and must be removed
                if (stack.isEmpty()) {
                    remove[i] = true;
                }
                // Otherwise, a valid pair is found → pop matching '('
                else {
                    stack.pop();
                }
            }
        }

        // Any '(' left in stack are unmatched → mark them invalid
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Pass 2 — Build final valid string by skipping invalid characters
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
