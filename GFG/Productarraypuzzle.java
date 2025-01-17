package GFG;

public class Productarraypuzzle {
    public static int[] productExceptSelf(int arr[]) {
        int totalProduct = 1;
        int zeroCnt = 0;
        int res[] = new int[arr.length];
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == 0)
            {
                zeroCnt++;
            }
            else
            {
                totalProduct *= arr[i];
            }
        }
        
        if(zeroCnt > 1)
        {
            return res;
        }
        else if(zeroCnt == 1)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i] == 0)
                {
                    res[i] = totalProduct;
                }
            }
            return res;
        }
        
        for(int i=0;i<arr.length;i++)
        {
            res[i] = totalProduct/arr[i];
        }
        
       return res;
     }
}
