package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTripletsWithZeroSum {
     public boolean findTriplets(int[] arr) {
        List<List<Integer>> res = testfindTriplets(arr);
  
        if(res.size() == 0)
        {
            return false;
        }
        
        return true;
    }
    
     static List<List<Integer>> testfindTriplets(int[] arr) {
        
        // Map to store indices for each value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // Resultant list
        List<List<Integer>> ans = new ArrayList<>();
        
        // Check for all pairs i, j
        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                
                // Value of third index should be 
                int val = -1 * (arr[j] + arr[k]);
                
                // If such indices exist
                if (map.containsKey(val)) {
                    
                    // Append the i, j, k
                    for (int i : map.get(val)) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }
            }
            
            // After j'th index is traversed
            // We can use it as i.
            map.putIfAbsent(arr[j], new ArrayList<>());
            map.get(arr[j]).add(j);
        }
        
        return ans;
    }
}
