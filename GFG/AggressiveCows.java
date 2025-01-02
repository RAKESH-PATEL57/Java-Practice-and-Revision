

import java.util.Arrays;

public class AggressiveCows 
{
    public static boolean canPlaceCows(int[] stalls, int k, int minDist) 
    {
        int cowsPlaced = 1;
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                cowsPlaced++;
                lastPosition = stalls[i];
                
                if (cowsPlaced == k) {
                    return true;
                }
            }
        }
        
        return false;
    }    
    
    public static int aggressiveCows(int[] stalls, int k) 
    {
        Arrays.sort(stalls);
        
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlaceCows(stalls, k, mid)) {
                result = mid;
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        
        return result;
    }
}
