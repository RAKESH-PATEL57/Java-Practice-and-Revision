package GFG;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArraysWithDistinct {
    public static int numberofElementsInIntersection(int a[], int b[]) {
        // Your code here
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num : a)
        {
            set.add(num);
        }
        
        for(int num : b)
        {
            if(set.contains(num))
            {
                res++;
            }
        }
        return res;  
    }
}
