package GFG;

import java.util.ArrayList;

public class CountingElementsInTwoArrays {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
       ArrayList<Integer> res = new ArrayList<>();
        
        // Find the maximum value in array b
        int maxB = 0;
        for(int i = 0; i < b.length; i++)
        {
            maxB = Math.max(maxB, b[i]);
        }
        
        // Create frequency array for elements in b
        int[] freq = new int[maxB + 1];
        for(int i = 0; i < b.length; i++) 
        
        {
            freq[b[i]]++;
        }
        
        // Calculate cumulative frequencies (prefix sum)
        // freq[i] now represents count of elements <= i in array b
        for(int i = 1; i <= maxB; i++) 
        {
            freq[i] += freq[i-1];
        }
        
        // For each element in array a, find count of elements in b that are <= a[i]
        for(int i = 0; i < a.length; i++) 
        {
            if(a[i] > maxB)
            {
                // If a[i] > maxB, then all elements in b are <= a[i]
                res.add(b.length);
            }
            
            else if(a[i] < 0) 
            {
                // If a[i] < 0, no elements in b are <= a[i] (assuming b has non-negative values)
                res.add(0);
            } 
            else 
            {
                // Otherwise get the count from our frequency array
                res.add(freq[a[i]]);
            }
        }
        
        return res;
    }
}
