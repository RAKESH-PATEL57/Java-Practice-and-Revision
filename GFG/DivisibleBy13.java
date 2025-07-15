package GFG;

public class DivisibleBy13 {
    public boolean divby13(String s) {
        // code here
        if (s == null || s.isEmpty()) {
            return false;
        }
        
        // Rule: A number is divisible by 13 if the alternating sum of blocks
        // of three digits from right to left is divisible by 13
        
        // The remainders when powers of 10 are divided by 13
        // 10^0 ≡ 1 (mod 13)
        // 10^1 ≡ 10 (mod 13)
        // 10^2 ≡ 9 (mod 13)
        // 10^3 ≡ 12 (mod 13)
        // 10^4 ≡ 3 (mod 13)
        // 10^5 ≡ 4 (mod 13)
        // And then the pattern repeats: 10^6 ≡ 1 (mod 13)
        int[] remainders = {1, 10, 9, 12, 3, 4, 1, 10, 9, 12, 3, 4};
        
        int result = 0;
        int length = s.length();
        
        // Process each digit from right to left
        for (int i = 0; i < length; i++) 
        {
            // Convert character to digit
            int digit = s.charAt(length - 1 - i) - '0';
            
            // Multiply digit by corresponding remainder and add to result
            result = (result + digit * remainders[i % 6]) % 13;
        }
        
        // If result is 0, the number is divisible by 13
        return result == 0;
    }
}
