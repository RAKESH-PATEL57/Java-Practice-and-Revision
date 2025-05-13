import java.util.HashMap;
import java.util.Map;

public class AtLeastKOccurrences {
    public int firstElementKTime(int[] arr, int k) {
     
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // Process each element in the original array order
        for (int num : arr) {
            // Increment the count for current element
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (map.get(num) >= k) 
            {
                return num; 
            }
        }
        
        return -1;
        
    }
}
