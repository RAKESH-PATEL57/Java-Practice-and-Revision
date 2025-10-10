import java.util.HashMap;
import java.util.Map;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ln = grid.length;
        int[] res = new int[2];

        int ans1 = 0;
        int ans2 = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<ln;i++)
        {
            for(int j=0;j<ln;j++)
            {
                map.put(grid[i][j], map.getOrDefault(grid[i][j],0)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 1)
            {
                ans1 = entry.getKey();
                break;
            }
        }

        for(int i=1;i<=ln*ln;i++)
        {
            // System.out.println(i);
            if(!map.containsKey(i))
            {
                ans2 = i;
                break;
            }
        }

        res[0] = ans1;
        res[1] = ans2;


        return res;
    }
}
