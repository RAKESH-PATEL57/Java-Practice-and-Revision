package GFG;

public class BitonicPoint {
    public int findMaximum(int[] arr) {
        // code here
        int res = arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            // System.out.println(arr[i] + " " + res);
            if(arr[i] > res)
            {
                res = arr[i];
            }
        }
        
        return res;
    }
}
