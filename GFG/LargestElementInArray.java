package GFG;

public class LargestElementInArray {
    public static int largest(int[] arr) 
    {
        int ln = arr.length;
        int p1=0;
        int p2=ln-1;
        
        int max = arr[0];
        
        while(p1<=p2)
        {
            if(arr[p1] > max)
            {
                max = arr[p1];
            }
            if(arr[p2] > max)
            {
                max = arr[p2];
            }
            p1++;
            p2--;
        }
        
        return max;
    }
}
