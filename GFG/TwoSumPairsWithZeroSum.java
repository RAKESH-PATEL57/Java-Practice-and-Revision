package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TwoSumPairsWithZeroSum {
     public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) 
    {
        ArrayList<ArrayList<Integer>> tempRes = new  ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(arr);
        int ln = arr.length;
        
        int p1=0;
        int p2=ln-1;
        
        while(p1<p2)
        {
            ArrayList<Integer> temp= new ArrayList<>();
            int sum = arr[p1]+arr[p2];
            
            if(sum == 0)
            {
                temp.add(arr[p1]);
                temp.add(arr[p2]);
                tempRes.add(temp);
                // tempRes.add(new ArrayList<>(temp)); // copy!
                // temp.clear(); // safe now
                p1++;
                p2--;
            }
            else if(sum<0)
            {
                p1++;
            }
            else
            {
                p2--;
            }
        }
        
        Set<List<Integer>> set = new LinkedHashSet<>(tempRes);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (List<Integer> subList : set) {
            res.add(new ArrayList<>(subList));
        }
        return res;
        
    }
    
    // [-4 -1 -1 0 1 2]
}
