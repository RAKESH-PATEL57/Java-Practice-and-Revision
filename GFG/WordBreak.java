package GFG;

public class WordBreak {
    public boolean wordBreak(String s, String[] dictionary) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Traverse through the given string
        for (int i = 1; i <= n; i++) {
            // Traverse through the dictionary words
            for (String w : dictionary) {
                // Check if the current word is present and
                // the prefix before the word is also
                // breakable
                int start = i - w.length();
                if (start >= 0 && dp[start]
                    && s.substring(start,
                                   start + w.length())
                           .equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n]; // Returning true or false
        
    }
}
