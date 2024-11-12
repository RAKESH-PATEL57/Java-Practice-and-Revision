package GFG;

import java.util.Arrays;

public class MeetingRooms 
{
    static boolean canAttend(int[][] arr) 
    {
        boolean res = true;
        int rowLn = arr.length;    
        int colLn = arr[0].length;  
        
        Arrays.sort(arr, (x, y) -> Integer.compare(x[0],y[0]));  
        
        // Arrays.sort(a, (x, y) -> Integer.compare(x[c],y[c]));  // c is the column number jiske basis pe sort karnaa chahate ho  
        
        for(int r=1; r<rowLn; r++)
        {
            for(int c=0; c<colLn-1; c++)
            {
               if(arr[r][c] >= arr[r-1][c+1])
               {
                   continue;
               }
               else
               {
                   res = false;
                   break;
               }
                
            }
        }
        return res;
    }    
}
