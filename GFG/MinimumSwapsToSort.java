import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapsToSort {
    public int minSwaps(int arr[]) {
        // Code here
        
        int n = arr.length;
        
       
        boolean[] vis = new boolean[n];
      
      	HashMap<Integer, Integer> pos = new HashMap<>();
      	
        for (int i = 0; i < n; i++) 
        {
            pos.put(arr[i], i);
        }

        Arrays.sort(arr);

        int swaps = 0;
        
        for (int i = 0; i < n; i++) 
        {

            if (vis[i] || pos.get(arr[i]) == i)
            {
                continue;
            }

            int j = i, cycleSize = 0;

            while (!vis[j]) 
            {
                vis[j] = true;
                j = pos.get(arr[j]);
                cycleSize++;
            }
            
            if (cycleSize > 0) 
            {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}
