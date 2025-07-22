package GFG;

public class SmallestPositiveMissing {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length;
 
        boolean[] present = new boolean[n + 1];

        for (int i = 0; i < n; i++)
        {
            if (arr[i] > 0 && arr[i] <= n) 
            {
                present[arr[i]] = true;
            }
        }
        
        for (int i = 1; i <= n; i++)
        {
            if (!present[i])
            {
                return i;
            }
        }
        
       
        return n + 1;
        
    }
}
