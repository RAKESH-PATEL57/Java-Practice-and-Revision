import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {

        int ln = nums.length;
        Map<Integer,Integer> temp = new HashMap<>();
        int res = 0;

        for(int i=0;i<ln;i++)
        {
            temp.put(nums[i], temp.getOrDefault(nums[i],0)+1); 
        }


        for(Map.Entry<Integer, Integer> entry : temp.entrySet())
        {
            if(entry.getValue() == 1)
            {
                res = entry.getKey();
                break;
            }
        }

        return res;
    }
}
