package GFG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Countdistinctelementsineverywindow {
    
    //method - 1
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int ln = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int j=0;

        for(int i = 0; i < ln; i++)
        {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            if(i>=k-1)
            {
                ans.add(freqMap.size());
                freqMap.put(arr[j],freqMap.get(arr[j])-1);
                if(freqMap.get(arr[j])==0)
                {
                    freqMap.remove(arr[j]);
                }
                j++; 
            }
        }
    }
    // method - 2
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = arr.length;

        // Initialize the frequency map for the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        res.add(freqMap.size());

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            // Remove the element going out of the window
            int outgoingElement = arr[i - k];
            freqMap.put(outgoingElement, freqMap.get(outgoingElement) - 1);
            if (freqMap.get(outgoingElement) == 0) {
                freqMap.remove(outgoingElement);
            }

            // Add the new element coming into the window
            int incomingElement = arr[i];
            freqMap.put(incomingElement, freqMap.getOrDefault(incomingElement, 0) + 1);

            // Add the count of distinct elements to the result
            res.add(freqMap.size());
        }

        return res;
    }
}
