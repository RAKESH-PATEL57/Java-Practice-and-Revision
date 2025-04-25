package GFG;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberIII {
     public int getSingle(int[] arr) {
        // code here
        int ln = arr.length;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num: arr)
        {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet() )
        {
            if(entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}
