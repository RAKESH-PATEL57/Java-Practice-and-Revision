package GFG;

public class SubstringsWithKDistinct {
    static int count(String s, int k) {
        int n = s.length();
        int ans = 0;

        // Use sliding window technique
        int[] freq = new int[26];
        int distinctCnt = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {

            // Expand window and add character
            freq[s.charAt(j) - 'a']++;
            if (freq[s.charAt(j) - 'a'] == 1) distinctCnt++;

            // Shrink window if distinct characters exceed k
            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;
                if (freq[s.charAt(i) - 'a'] == 0) distinctCnt--;
                i++;
            }

            // Add number of valid substrings ending at j
            ans += j - i + 1;
        }

        return ans;
    }
    
    int countSubstr(String s, int k) {
        // your code here
         int n = s.length();
        int ans = 0;

        ans = count(s, k) - count(s, k - 1);

        return ans;
    }
}
