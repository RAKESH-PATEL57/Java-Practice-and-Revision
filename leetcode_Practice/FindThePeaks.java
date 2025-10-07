import java.util.ArrayList;
import java.util.List;

public class FindThePeaks {
    public List<Integer> findPeaks(int[] mountain) 
    {
       ArrayList<Integer> res = new ArrayList<Integer>();

       int ln = mountain.length;
       

       for(int i=1;i<ln-1;i++)
       {
          int previous = mountain[i-1];
          int current = mountain[i];
          int next = mountain[i+1];

          if((current > previous) && (current > next))
          {
            res.add(i);
          }
       }


       return res;
    }
}
