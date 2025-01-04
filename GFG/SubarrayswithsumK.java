package GFG;

public int countSubarrays(int arr[], int k) 
    {
        int res = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize the map with prefix sum 0
        map.put(0, 1);
        
        for (int num : arr) {
            prefixSum += num;
            
            // Check if prefixSum - k exists in the map
            if (map.containsKey(prefixSum - k)) {
                res += map.get(prefixSum - k);
            }
            
            // Update the map with the current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
     
       
       return res;
    }