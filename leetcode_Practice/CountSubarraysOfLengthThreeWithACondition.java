public class CountSubarraysOfLengthThreeWithACondition {
    public int countSubarrays(int[] nums) {
        int res = 0;
        int ln = nums.length;

        for (int i = 1; i < ln - 1; i++) 
        {
            float fts = nums[i - 1] + nums[i + 1];
            float s =  (float) nums[i] / 2;

            if (fts == s) 
            {
                res++;
            }
        }

        return res;
    }
}
