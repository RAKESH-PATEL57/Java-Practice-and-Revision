import java.util.Arrays;

public class MinimumNumberGame {
    public int[] numberGame(int[] nums) 
    {
        Arrays.sort(nums);
        int ln = nums.length;
        int res[] = new int[ln];

        for(int i=0;i<ln;i++)
        {
           if(i%2 == 0)
           {
            res[i+1] = nums[i];
           }
           else
           {
            res[i-1] = nums[i];
           }
        }

        // [0,1,2,3]    [2,3,4,5]
        // [1,0,3,2]    [3,2,5,4]
  

        return res;    
    }
}
