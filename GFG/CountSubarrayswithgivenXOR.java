package GFG;

import java.util.HashMap;

public class CountSubarrayswithgivenXOR {
        public long subarrayXor(int arr[], int k) {
        int count = 0;
        int prefixXor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize the map with XOR 0
        map.put(0, 1);
        
        for (int num : arr) {
            prefixXor ^= num; // Update the prefix XOR
            
            // Check if prefixXor ^ k exists in the map
            int target = prefixXor ^ k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            
            // Update the map with the current prefix XOR
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        
        return count;
    }
}
