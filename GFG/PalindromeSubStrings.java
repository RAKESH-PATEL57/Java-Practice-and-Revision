package GFG;

public class PalindromeSubStrings {
    private int palinCount(int left, int right, String s) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return count;
    }
    
    public int countPS(String s) {
        int n = s.length();
        int oddCount = 0;
        int evenCount = 0;
        
        for (int i = 0; i < n; i++) {
            oddCount += palinCount(i - 1, i + 1, s);  // For odd-length palindromes
        }
        
        for (int i = 1; i < n; i++) {
            evenCount += palinCount(i - 1, i, s);  // For even-length palindromes
        }
        
        return oddCount + evenCount;
    }
}
