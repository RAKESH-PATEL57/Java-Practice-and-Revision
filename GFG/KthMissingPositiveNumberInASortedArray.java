package GFG;

public class KthMissingPositiveNumberInASortedArray {
    public int kthMissing(int[] arr, int k) 
    {
        int ln = arr.length;
        int start= 0;
        int end = ln-1;
        
        while(start <= end)
        {
          int mid = (start+end)/2;
          int missing = arr[mid] - mid - 1;
          
          if(missing<k)
          {
              start = mid + 1;
          }
          else
          {
              end = mid - 1;
          }
           
        }
        
        
        return start + k;
    }
}
