package GFG;

public class MoveAllZeros 
{
    void pushZerosToEnd(int[] arr) 
    {
        int ln = arr.length;
        
        int j=0;
        
        for(int i=0; i<ln; i++)
        {
            if(arr[i] != 0)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j++] = temp;
            }
        }
    }    
}
