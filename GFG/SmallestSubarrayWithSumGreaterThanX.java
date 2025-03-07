package GFG;

public class SmallestSubarrayWithSumGreaterThanX {
    public static int smallestSubWithSum(int x, int[] arr) 
    {
        int res = Integer.MAX_VALUE;
        int ln = arr.length;
        
        int p1=0;
        int p2=0;
        int sum = 0;
        int min = 0;
        
        while(p2<ln)
        {
            sum += arr[p2];
           
            if(sum > x)
            {
                min = p2-p1+1;
                res = res < min ? res : min;
                
                while(p1<p2 && sum > x)
                {
                   sum -= arr[p1];
                   p1++;
                   if(sum > x)
                   {
                       min = p2-p1+1;
                       res = res < min ? res : min;
                   }
                }
            }
    
            p2++;
         
        }

        
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
