package GFG;

import java.util.Arrays;

public class getSecondLargest 
{
     public int getSecondLargest(int[] arr) 
    {
        int ln = arr.length;
        
        Arrays.sort(arr);
        
        int firstLargest = arr[ln-1]; 
        int secondLargest = arr[ln-2]; 

      
            int condition = 0;
            int p1 = ln-1;  // 2
            int p2 = ln-2;  // 1
            boolean check = false;
            boolean insideLoop = false;
            
            int res = 0; 
            
            if(firstLargest == secondLargest)
            {
                insideLoop = true;
            
                while((firstLargest == secondLargest) && condition <ln-1)
                {
                   
                    
                    firstLargest = arr[p1];
                    secondLargest = arr[p2];
                  
                    
                    if((firstLargest != secondLargest))
                    {
                        check = true;
                        break;
                    }
                    condition++;
                    p1--;
                    p2--;
                
                }
            
            }
            
            if(insideLoop == false)
            {
                res = secondLargest;
            }
            
            else
            {
                res = (check == true) ? secondLargest : -1;
            }
        
        
        // [5 10 10]
        // [  p2 p1]
        
        
        return res;
    }    
}
