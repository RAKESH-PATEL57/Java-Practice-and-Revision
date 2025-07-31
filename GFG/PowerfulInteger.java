package GFG;

import java.util.HashMap;
import java.util.Map;

public class PowerfulInteger {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        
        int ln = intervals.length;
        
        for(int i=0;i<ln;i++)
        {
            int numf= intervals[i][0];
            int nums= intervals[i][1];
            
            for(int j=numf;j<=nums;j++)
            {
              map.put(j,map.getOrDefault(j,0)+1);
            }
        }
        
        
        int res = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if (entry.getValue() >= k)
            {
                res = Math.max(res, entry.getKey());
            }
        }
        
        if(res>0)
        {
            return res;
        }
        
        return -1;
    }
}
