class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int ln = nums.length;

        for(int i=0;i<ln;i++)
        {
            if((nums[i] == target ) || (nums[i]> target))
            {
                return i;
            }
        }

        return ln;
    }
}