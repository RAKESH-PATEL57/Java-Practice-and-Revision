package GFG;

public class SortZeroOneTwo
{

    // method one  
    
    public void sort012(int[] arr) 
    {
        int z=0;
        int o=0;
        int t=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == 0)
            {
                z++;
            }
            else if(arr[i] == 1)
            {
                o++;
            }
            else
            {
                t++;
            }
            
        }
        
        int index=0;
        
        while(z>0)
        {
            arr[index++] = 0;
            z--;
            
        }
        while(o>0)
        {
            arr[index++] = 1;
            o--;
           
        }
        while(t>0)
        {
            arr[index] = 2;
            t--;
            index++;
        }
    }   
    
    
    // method two

    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
    
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid] and move both pointers
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Move mid pointer only
                mid++;
            } else {
                // Swap arr[mid] and arr[high] and move high pointer
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
    
}




