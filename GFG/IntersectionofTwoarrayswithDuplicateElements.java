import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionofTwoarrayswithDuplicateElements {
     public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) 
    {
       ArrayList<Integer> res = new ArrayList<>();
  
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int x:a)
       {
           map.put(x,1);
       }
       for(int x:b)
       {
            if(map.get(x)!=null && map.get(x)!=0)
            {
                res.add(x);
                map.put(x,0);
            }
        }
       return res;
    }
}
