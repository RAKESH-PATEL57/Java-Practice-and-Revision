package GFG;

public class MissingElementOfAP {
    public int findMissing(int[] arr) {
        // code here
        int ln = arr.length;
        int diff = arr[1] - arr[0];
        int res = arr[ln-1] + diff;
        
       
        for(int i=1;i<ln;i++)
        {
            int toExistsNum = arr[i-1] + diff;
            
            if(arr[i] != toExistsNum)
            {
                return toExistsNum;
            }
        } 
        return res;
    }
}
