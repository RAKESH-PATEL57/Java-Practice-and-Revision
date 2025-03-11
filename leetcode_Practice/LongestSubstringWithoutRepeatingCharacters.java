import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
     public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n=s.length();

        HashSet<Character> set = new HashSet<>();

        int maxLen = Integer.MIN_VALUE;

        while(windowEnd<n)
        {
            char ch = s.charAt(windowEnd);
            if(set.contains(ch))
            {
                //shrinking
                while(windowStart<windowEnd && set.contains(ch))
                {
                    set.remove(s.charAt(windowStart));
                    windowStart++;
                }
            }
            set.add(ch);

            maxLen = Math.max(maxLen, windowEnd - windowStart+1);

            windowEnd++;
        }

        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
    }


    // solution 2 (optimized as compare to previous one)
     public int lengthOfLongestSubstring(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n=s.length();

 
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;

        while(windowEnd<n)
        {
            char ch = s.charAt(windowEnd);
            if(map.containsKey(ch) && map.get(ch)>=windowStart)
            {
               //shrinking
               windowStart = map.get(ch)+1;
            }
            
            map.put(ch,windowEnd);

            maxLen = Math.max(maxLen, windowEnd - windowStart+1);

            windowEnd++;
        }

        return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
     }
}
