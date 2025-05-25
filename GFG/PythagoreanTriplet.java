package GFG;

import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplet {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int ln = arr.length;
        
        Set<Integer> sq = new HashSet<>();
        
        
        for(int i=0;i<ln;i++)
        {
            int sqNum = arr[i] * arr[i];
            sq.add(sqNum);
        }
        
        for(int i=0;i<ln;i++)
        {
            int a = arr[i];
            
            for(int j=i+1;j<ln;j++)
            {
                int b = arr[j];
                int reqNum = (a*a) + (b*b);
                
                if(sq.contains(reqNum))
                {
                    return true;
                }
            }
        }
  
        return false;
    }
}
