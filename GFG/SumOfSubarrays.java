package GFG;

public class SumOfSubarrays {
    public int subarraySum(int[] arr) {
        // code here
        int totalSum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; i++) 
        {
            totalSum += arr[i] * (i + 1) * (n - i);
        }
        
        return totalSum;
    }
}
