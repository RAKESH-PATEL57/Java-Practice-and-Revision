package GFG;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
    static boolean findsum(int arr[]) {

        Set<Integer> hs = new HashSet<Integer>();
        int ln = arr.length;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) 
        {
            sum += arr[i];
            
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
            {
                return true;
            }

            hs.add(sum);
        }

        return false;
    }
}
