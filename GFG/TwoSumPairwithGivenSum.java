package GFG;

import java.util.HashMap;

public class TwoSumPairwithGivenSum {
    boolean twoSum(int arr[], int target) 
    {
        int ln = arr.length;
       
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < ln; i++) {
            int complement = target - arr[i];

            // Check if the complement exists in the hash map
            if (map.containsKey(complement)) {
                return true;
            }

            // Add the current element to the hash map
            map.put(arr[i], i);
        }

        // No pair found
        return false;
    }
}
