package GFG;

public class LargestNumberInKSwaps {
    static void match(String curr, 
                             StringBuilder result) {
        
        // If current number is larger, update result
        if (curr.compareTo(result.toString()) > 0) {
            result.replace(0, result.length(), curr);
        }
    }

    // Function to set highest possible digits at given index
    static void setDigit(StringBuilder s, 
                        int index, StringBuilder res, int k) {
        
        // Base case: If no swaps left or index reaches 
        // the last character, update result
        if (k == 0 || index == s.length() - 1) {
            match(s.toString(), res);
            return;
        }

        int maxDigit = 0;

        // Finding maximum digit for placing at given index
        for (int i = index; i < s.length(); i++) {
            maxDigit = Math.max(maxDigit, s.charAt(i) - '0');
        }

        // If the digit at current index is already max
        if (s.charAt(index) - '0' == maxDigit) {
            setDigit(s, index + 1, res, k);
            return;
        }

        // Try swapping with the maximum digit found
        for (int i = index + 1; i < s.length(); i++) {
            
            // If max digit is found at current position
            if (s.charAt(i) - '0' == maxDigit) {
                
                // Swap to get the max digit at the required index
                char temp = s.charAt(index);
                s.setCharAt(index, s.charAt(i));
                s.setCharAt(i, temp);

                // Call the recursive function to set
                // the next digit
                setDigit(s, index + 1, res, k - 1);

                // Backtrack: swap the digits back
                s.setCharAt(i, s.charAt(index));
                s.setCharAt(index, temp);
            }
        }
    }

    // Function to find the largest number after k swaps
    static String findMaximumNum(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        setDigit(new StringBuilder(s), 0, res, k);

        // Returning the result
        return res.toString();
    }
}
