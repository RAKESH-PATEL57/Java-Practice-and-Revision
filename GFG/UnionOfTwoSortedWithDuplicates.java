import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfTwoSortedWithDuplicates {
     public static ArrayList<Integer> findUnion(int a[], int b[]) 
    {
        Set<Integer> st = new TreeSet<>();

        for (int i = 0; i < a.length; i++)
            st.add(a[i]);

        for (int i = 0; i < b.length; i++)
            st.add(b[i]);

        ArrayList<Integer> res = new ArrayList<>(st);
        return res;
        
    }
}
