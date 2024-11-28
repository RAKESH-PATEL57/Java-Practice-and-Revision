package GFG;

public class SmallestPositiveMissingNumber 
{
    public int missingNumber(int[] arr) 
    {
        int ln = arr.length;
        int i=0;
        
        while(i<ln)
        {
            if(arr[i]>0 && arr[i] <= ln && arr[i] != arr[arr[i] - 1])
            {
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp - 1] = temp;
            }
            
            else
            {
                i++;
            }
            
            
        }
        for(i=0; i<ln; i++)
        {
            if(arr[i] != i+1)
            {
                return i+1;
            }
        }
        return ln+1;
    }    
}
