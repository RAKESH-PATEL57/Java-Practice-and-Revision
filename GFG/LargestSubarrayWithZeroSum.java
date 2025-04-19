package GFG;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
     int maxLen(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
    
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
    
            if (sum == 0) {
                maxLen = i + 1;
            }
    
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
    
        return maxLen;
    }
}
