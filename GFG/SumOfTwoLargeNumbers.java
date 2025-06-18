package GFG;

public class SumOfTwoLargeNumbers {
    String findSum(String s1, String s2) {
        // code here
         if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        // Reverse both strings to make addition easier
        StringBuilder str1 = new StringBuilder(s1).reverse();
        StringBuilder str2 = new StringBuilder(s2).reverse();
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = 0;
        
        // Add corresponding digits
        for (; i < str2.length(); i++) {
            int sum = (str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        
        // Add remaining digits of the longer string
        for (; i < str1.length(); i++) {
            int sum = (str1.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        
        // If carry remains
        if (carry != 0) {
            result.append(carry);
        }
        
        // Reverse result to get the final sum
        // Remove leading zeros, if any
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.setLength(result.length() - 1);
        }
        
        return result.reverse().toString();
    }
}
