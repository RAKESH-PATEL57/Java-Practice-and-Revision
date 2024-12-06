package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public enum ArrayDuplicates {

    // method one

    public List<Integer> findDuplicates(int[] arr) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        Arrays.sort(arr);
        
        
        int rkBhai = 0;
        
        for(int i=1; i<arr.length; i++)
        {
            if(arr[rkBhai] != arr[i])
            {
                rkBhai++;
            }
            
            else
            {
                res.add(arr[rkBhai]);
                rkBhai++;
            }
        }
        return res;
    }


    //method two

    public List<Integer> findDuplicates(int[] arr) {
    ArrayList<Integer> res = new ArrayList<>();
    HashSet<Integer> seen = new HashSet<>();
    
    for (int num : arr) {
        // If the number is already in the set, it's a duplicate
        if (!seen.add(num)) {
            res.add(num);
        }
    }
    return res;
}
}
