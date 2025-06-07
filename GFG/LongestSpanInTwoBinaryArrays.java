package GFG;

import java.util.HashMap;

public class LongestSpanInTwoBinaryArrays {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        int n = a1.length;
        int res = 0;
        
        // Hash map to store first occurrence of each difference
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            
            int currentDiff = sum1 - sum2;
            
            // If difference is 0, entire subarray 
            // from 0 to i has equal sum
            if (currentDiff == 0) {
                res = Math.max(res, i + 1);
            }
            
            // If this difference has been seen before
            else if (diffMap.containsKey(currentDiff)) {
                res = Math.max(res, i - diffMap.get(currentDiff));
            } 
            else {
                
                // Store first occurrence of this difference
                diffMap.put(currentDiff, i);
            }
        }
        
        return res;
    }
}
