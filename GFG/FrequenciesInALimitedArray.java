package GFG;

import java.util.ArrayList;
import java.util.List;

public class FrequenciesInALimitedArray {
     public List<Integer> frequencyCount(int[] arr) 
    {
        List<Integer> res = new ArrayList<>();
        int ln = arr.length;
        
        for(int i=0;i<ln;i++)
        {
            res.add(0);
        }
        
        for(int i=0;i<ln;i++)
        {
            int indexToUpdate = arr[i] - 1;
            int countUpdate = res.get(indexToUpdate) + 1;
            res.set(indexToUpdate,countUpdate);
        }
          
        return res;
    }
}
