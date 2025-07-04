package GFG;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithAtMostKDistinctIntegers {
    public int countAtMostK(int arr[], int k) {
        // code here
        
        int ln = arr.length;
        int res = ln;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int left = 0;
        
        for(int right=0;right<ln;right++)
        {
            
            map.put(arr[right],map.getOrDefault(arr[right],0) + 1);
            
            
            while(map.size() > k)
            {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            
            res += right - left;
            
        }
        
        
        return res;
    }
}
