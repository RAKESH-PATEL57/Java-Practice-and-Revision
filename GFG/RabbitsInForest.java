package GFG;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public int numRabbits(int[] answers) 
    {
          Map<Integer, Integer> map = new HashMap<>();

          int res = 0;

          for(int ans: answers)
          {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
          }
          
          for(Map.Entry<Integer, Integer> entry : map.entrySet())
          {
            int x = entry.getKey();
            int count = entry.getValue();
            int groups = (int) Math.ceil((double) count/ (x+1));
            res += groups * (x + 1);
          }


          return res;  
    }
}
