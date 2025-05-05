package GFG;

public class SearchInAnAlmostSortedArray {
    public int findTarget(int arr[], int target) {
        // code here
        int p1=0;
        int p2= arr.length-1;
        
        
        while(p1<=p2)
        {
            
            if(arr[p1] == target)
            {
                return p1;
            }
            if(arr[p2] == target)
            {
                return p2;
            }
            p1++;
            p2--;
        }
        
        
        return -1;
    }
}
