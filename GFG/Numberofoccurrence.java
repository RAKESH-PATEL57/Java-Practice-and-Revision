package GFG;

public class Numberofoccurrence 
{
    int countFreq(int[] arr, int target) 
    {
        int p1=0;
        int p2=arr.length-1;
        int res = 0;
        
        if(arr.length % 2 == 0)
        {
            while(p1<p2)
            {
                if(arr[p1] == target)
                {
                    res++;
                }
                if(arr[p2] == target)
                {
                    res++;
                }
                p1++;
                p2--;
            }
        }
        
        else
        {
            int p1Length = arr.length/2;
            int p2Length = arr.length-p1Length;
            while(p1<=p1Length)
            {
                if(arr[p1] == target)
                {
                    res++;
                }
                p1++;
            }
            while(p2>=p2Length)
            {
                if(arr[p2] == target)
                {
                    res++;
                }
                p2--;
            }
        }
        
        return res;
    } 
}
