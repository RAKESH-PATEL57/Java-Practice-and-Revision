package GFG;

import java.util.Arrays;

public class MinimizetheHeightsI 
{
     public int getMinDiff(int k, int[] arr) 
    {
       int ln = arr.length;
       
       Arrays.sort(arr);
       
       int min=0;
       int max=0;
       
       int res = arr[ln-1]-arr[0];
       
       
         for(int i=0;i<=ln-2;i++)
         {
            max=Math.max(arr[ln-1]-k, arr[i]+k);
            min=Math.min(arr[0]+k, arr[i+1]-k);
            
            res=Math.min(res, max-min);
        }

        return res;
    }    
}
