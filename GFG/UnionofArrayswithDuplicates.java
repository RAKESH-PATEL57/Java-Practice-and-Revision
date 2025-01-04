package GFG;

import java.util.HashMap;

public class UnionofArrayswithDuplicates {
      public static int findUnion(int a[], int b[]) {
      
       HashMap<Integer,Integer> temp = new HashMap<>();
       int res=0;
       
       for(int i=0;i<a.length;i++)
       {
           if( temp.get(a[i]) == null)
           {
               res++;
           }
           temp.put(a[i],1);
       }
       
       for(int i=0;i<b.length;i++)
       {
           if( temp.get(b[i]) == null)
           {
               res++;
           }
           temp.put(b[i],1);
       }
       
       return res;
    }
}
