package GFG;

import java.util.Arrays;

public class MissingInArray {
     int missingNumber(int n, int arr[]) 
    {
        Arrays.sort(arr);
        int ln = arr.length;
        int res = 0;
        
        for(int i= ln-1; i>=0; i--)
        {
            if(arr[i] != (n))
            {
                res = n;
                break;
            }
            n--;
        }
        
        if((res == 0) && (arr[0] != 1))
        {
            res = 1;
        }
        
        return res;
    }
}
