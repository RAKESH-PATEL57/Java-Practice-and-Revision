package GFG;

import java.util.ArrayList;

public class IndexesofSubarraySum2 {
        static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int ln = arr.length;
        int p1 = 0;
        
        int sum = arr[p1];
        
        if(sum == target)
        {
            res.add(p1+1);
            res.add(p1+1);
            
            return res;
        }
        
        for(int i=1;i<ln;i++)
        {
            
            sum += arr[i];
            if(sum == target)
            {
                res.add(p1+1);
                res.add(i+1);
                break;
            }
            else if(sum > target)
            {
               
                while(sum > target)
                {
                   sum -= arr[p1];
                   p1++;
                }
                
                if(sum == target)
                {
                    res.add(p1+1);
                    res.add(i+1);
                    break;
                }
            }
        
        }
        
        if(res.size() == 0)
        {
            res.add(-1);
        }
        
        return res;
    }
}
