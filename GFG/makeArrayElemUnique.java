package GFG;

import java.util.Arrays;

public class makeArrayElemUnique 
{
    public int minIncrements(int[] arr) 
    {
        Arrays.sort(arr);
        int ln = arr.length;
        int res = 0;
        
        for(int i=1; i<ln; i++)
        {
            if(arr[i] <= arr[i-1])
            {
                int temp1 = arr[i-1] + 1;
                int temp2 = temp1 - arr[i];
                arr[i] = arr[i-1] + 1;
                
                res += temp2;
                
            }
        }
        
        return res;
    }    
}
