package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {
    public int findMinDiff(ArrayList<Integer> arr, int m) 
    {
       int res = Integer.MAX_VALUE;
       Collections.sort(arr);
       int sub;
       
       int ln = arr.size();
       
       for(int i=0;i<=ln-m;i++)
       {
           sub = arr.get(m-1+i) - arr.get(i);
           res = res < sub ? res : sub;
       }
       
       
       return res;
    }
}
