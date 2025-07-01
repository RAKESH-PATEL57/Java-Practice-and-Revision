package GFG;

public class SubstringsOfLengthKWithKOneDistinctElements {
    public int substrCount(String s, int k) {
        // code here
        return countAtMost(s, k, k-1) - countAtMost(s, k, k-2);
    }
    
    private int countAtMost(String s, int length, int distinctLimit) {
        if (distinctLimit < 0) return 0;
        
        int result = 0;
        int[] charCount = new int[26]; // For lowercase alphabets (a-z)
        int distinctCount = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Add the current character to our window
            int rightCharIndex = s.charAt(right) - 'a';
            charCount[rightCharIndex]++;
            
            // If this is a new character, increment our distinct count
            if (charCount[rightCharIndex] == 1) {
                distinctCount++;
            }
            
            // Shrink window from left if we have too many distinct characters
            while (distinctCount > distinctLimit) {
                int leftCharIndex = s.charAt(left) - 'a';
                charCount[leftCharIndex]--;
                
                // If we've removed all instances of this character, reduce distinct count
                if (charCount[leftCharIndex] == 0) {
                    distinctCount--;
                }
                left++;
            }
            
            // If our window is at least of length k, count valid substrings
            // We only count those ending at the current position (right)
            if (right - left + 1 >= length) {
                // We want exactly length k, so we might need to shrink from left
                while (right - left + 1 > length) {
                    int leftCharIndex = s.charAt(left) - 'a';
                    charCount[leftCharIndex]--;
                    if (charCount[leftCharIndex] == 0) {
                        distinctCount--;
                    }
                    left++;
                }
                
                // Now our window is exactly of length k
                if (right - left + 1 == length) {
                    result++;
                }
            }
        }
        
        return result;
    }
}
