package GFG;

public class EquilibriumPoint {
    public static int findEquilibrium(int arr[]) 
    {
        int ln = arr.length;
        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;
        
        for(int i=0;i<ln;i++)
        {
             sum += arr[i];
        }
        
        for(int i=1;i<ln;i++)
        {
            leftSum += arr[i-1];
            rightSum = sum - (leftSum + arr[i]);
            
            if(leftSum == rightSum)
            {
                return i;
            }
        }
        
        return -1;
    }
}
