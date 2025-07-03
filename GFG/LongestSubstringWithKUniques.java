package GFG;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {
    // method one
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int windowStart = 0;
        int windowEnd = 0;
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        int freqHash[] = new int[26];
        int uniqueCharCount = 0;
        while (windowEnd < n) {
            int index = s.charAt(windowEnd) - 97;
            if (freqHash[index] == 0) {
                uniqueCharCount++;
                freqHash[index]++;
            } else {
                freqHash[index]++;
            }
            if (uniqueCharCount == k) {
                len = windowEnd - windowStart + 1;
                maxLen = Math.max(maxLen, len);
            } else if (uniqueCharCount > k) {
                while (windowStart < windowEnd && uniqueCharCount > k) {
                    index = s.charAt(windowStart) - 97;
                    windowStart++;
                    freqHash[index]--;
                    if (freqHash[index] == 0) {
                        uniqueCharCount--;
                    }
                }
            }
            windowEnd++;
        }

        return (maxLen == Integer.MIN_VALUE) ? -1 : maxLen;

    }

    // method two
    public int longestKSubstr(String s, int k) {
        // code here
        if (s == null || s.length() == 0 || k <= 0) {
            return -1;
        }

        // Sliding window approach
        int left = 0;
        int maxLength = -1;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

            // If we have more than k distinct characters, shrink the window
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // If we have exactly k distinct characters, update maxLength
            if (charCount.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
