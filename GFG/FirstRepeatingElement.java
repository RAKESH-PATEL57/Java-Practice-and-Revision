package GFG;

import java.util.HashSet;

public class FirstRepeatingElement {
    public static int firstRepeated(int[] arr) {
        HashSet<Integer> repeatingElements = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : arr) 
        {
            if (!set.add(num)) 
            { 
                repeatingElements.add(num);
            }
        }
        
        for (int i = 0; i < arr.length; i++) 
        {
            if (repeatingElements.contains(arr[i])) {
                return i + 1;
            }
        }
        
        return -1;
    }
}
