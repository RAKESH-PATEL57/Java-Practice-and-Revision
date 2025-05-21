package GFG;

import java.util.ArrayList;

public class AlternatePositiveNegative {
     void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        
        int ln = arr.size();
        
        for(int i=0;i<ln;i++)
        {
            int num = arr.get(i);
            if( num < 0)
            {
                neg.add(num);
            }
            else
            {
                pos.add(num);
            }
        }
        
        int posSize = pos.size();
        int negSize = neg.size();
    
        int n=0;
        int index=0;
        int p=0;
     
        // Alternate positive and negative
        while (p < posSize && n < negSize) 
        {
            arr.set(index++, pos.get(p++));
            arr.set(index++, neg.get(n++));
        }
    
        // Add remaining positives
        while (p < posSize) 
        {
            arr.set(index++, pos.get(p++));
        }
        // Add remaining negatives
        while (n < negSize) 
        {
            arr.set(index++, neg.get(n++));
        }
        
    }
}
