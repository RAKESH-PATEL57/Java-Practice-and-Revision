package GFG;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithAtmostTwoDistinctIntegers {
    public int totalElements(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // If array has only one element
        if (arr.length == 1) {
            return 1;
        }
        
        int maxLength = 0;
        int left = 0;
       
        Map<Integer, Integer> numCount = new HashMap<>();
        
        for (int right = 0; right < arr.length; right++) {
            // Add current element to our count
            numCount.put(arr[right], numCount.getOrDefault(arr[right], 0) + 1);
            
            // If we have more than 2 distinct integers, shrink window from left
            while (numCount.size() > 2) {
                numCount.put(arr[left], numCount.get(arr[left]) - 1);
                if (numCount.get(arr[left]) == 0) {
                    numCount.remove(arr[left]);
                }
                left++;
            }
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
