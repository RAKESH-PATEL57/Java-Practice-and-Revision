package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders 
{
    static ArrayList<Integer> leaders(int arr[]) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int max = arr[arr.length-1];
        
        res.add(max);
        
        for(int i=arr.length-2; i>=0;i--)
        {
           if(arr[i] >= max)
           {
               res.add(arr[i]);
               max = arr[i];
           }
        }
        
        Collections.reverse(res);
        
        return res;
    }    
}
