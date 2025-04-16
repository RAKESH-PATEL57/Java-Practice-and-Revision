package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckEqualArrays {


    //see third approach (optimized 👨‍💻)

    //first approach
     public static boolean checkEqual(int[] a, int[] b) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int num : a) arr1.add(num);
        for (int num : b) arr2.add(num);
        Collections.sort(arr1);
        Collections.sort(arr2);
        return arr1.equals(arr2);
    }

    //second approach
     public static boolean checkEqual(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    //third approach(Optimized)
        public static boolean checkEqual(int[] a, int[] b) {
        Map<Integer, Integer> freqMapA = new HashMap<>();
        Map<Integer, Integer> freqMapB = new HashMap<>();
        
        for(int num : a)
        {
           freqMapA.put(num, freqMapA.getOrDefault(num, 0) + 1);
        }
        
        for(int num: b)
        {
            freqMapB.put(num, freqMapB.getOrDefault(num, 0) + 1);
        }
        
        return freqMapA.equals(freqMapB);
    }
}
