public class CheckIfArrayIsSorted {
    public boolean arraySortedOrNot(int[] arr) {
        
        if(arr.length == 1)
        {
            return true;
        }
        
        int p1= 0;
        int p2= 1;
        
        while(p2<arr.length)
        {
            int curr = arr[p1];
            int next = arr[p2];
            
            if(curr > next)
            {
                return false;
            }
            
            p1++;
            p2++;
        }
        
        return true;
        
    }
}
