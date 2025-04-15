package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckEqualArrays {

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
}
