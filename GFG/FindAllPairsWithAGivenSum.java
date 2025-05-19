import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPairsWithAGivenSum {
    public pair[] allPairs(int target, int arr1[], int arr2[]) {
        
        Arrays.sort(arr1);
        
        // Add all elements of arr2 to a HashSet for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        
        // Create frequency map for elements in arr2
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // ArrayList to store result pairs
        List<pair> resultList = new ArrayList<>();
        
        // Process each element in arr1
        for (int u : arr1) {
            int v = target - u;
            
            // If complement exists in arr2
            if (set.contains(v)) {
                // Add pair for each occurrence of v in arr2
                for (int i = 0; i < freqMap.get(v); i++) {
                    resultList.add(new pair(u, v));
                }
            }
        }
        
        // Convert ArrayList to array
        pair[] result = new pair[resultList.size()];
        return resultList.toArray(result);
    }
}
