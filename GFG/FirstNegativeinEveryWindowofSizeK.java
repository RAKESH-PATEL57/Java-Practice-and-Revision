package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeinEveryWindowofSizeK {
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int ln = arr.length;
        
        
        for(int i=0;i<k;i++)
        {
            if(arr[i] < 0)
            {
                queue.offer(arr[i]);
            }
            
        }
        
        int firstNegNum = queue.isEmpty() ? 0 : queue.peek();
        
        res.add(firstNegNum);
        
        for(int i=1; i<ln-k+1; i++)
        {
            if(arr[i-1]<0)
            {
                queue.poll();
            }
            
            if(arr[i+k-1] < 0)
            {
                queue.offer(arr[i+k-1]);
            }
            
            int negNum = queue.isEmpty() ? 0 : queue.peek();
        
            res.add(negNum);
        }
        
        
      
 
        return res;
    }
}
