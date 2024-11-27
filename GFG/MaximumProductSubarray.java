package GFG;

public class MaximumProductSubarray 
{
    int maxProduct(int[] arr) 
    {
        int ln= arr.length;
        int res = Integer.MIN_VALUE;
        
        int productStart = 1;
        int productEnd = 1;
        
        for(int i=0;i<ln;i++)
        {
            productStart *= arr[i]; 
            productEnd *= arr[ln-1-i];
            
            res = Math.max(res,Math.max(productStart,productEnd));
            
            if(productStart == 0)
            {
                productStart = 1;
            }
            
            if(productEnd == 0)
            {
                productEnd = 1;
            }
        }
        
        
        
        return res;
    }    
}
