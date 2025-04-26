package GFG;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


    //approach - 1
    static int majorityElement(int arr[]) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int ln = arr.length;
        int check = ln/2;
        
        
        for(int num: arr)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() > check)
            {
                return entry.getKey();
            }
        }
        
        
        return -1;
    }
    
    // approach - 2
    static int majorityElement(int arr[]) 
    {
      int candidate = arr[0], count = 1;
    
      // Phase 1: Find a potential majority element
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] == candidate) 
            {
                count++;
            } else 
            {
                count--;
                if (count == 0)
                {
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
    
        // Phase 2: Verify if the candidate is a majority element
        count = 0;
        for (int num : arr) 
        {
            if (num == candidate) 
            {
                count++;
            }
        }
        
        return count > arr.length / 2 ? candidate : -1;
    }
}
