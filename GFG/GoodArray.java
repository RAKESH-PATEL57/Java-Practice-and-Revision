package GFG;

import java.util.HashMap;
import java.util.Map;

public class GoodArray {
     public int goodArray(int arr[], int k) 
    {
        int ln = arr.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        
        for (int i : arr) { 
            map.put(i, map.getOrDefault(i, 0)+1); 
        } 
        
        for(int i=0;i<ln;i++) {
            if (map.get(arr[i]) > 0) {
                int n = k ^ arr[i];
                map.put(arr[i], map.get(arr[i]) - 1);   //if we use the number then remove it
                int availibility = map.getOrDefault(n, 0);
                if (availibility > 0) {
                    map.put(n, availibility-1);
                } else {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
