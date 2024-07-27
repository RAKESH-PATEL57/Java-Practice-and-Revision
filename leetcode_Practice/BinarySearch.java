class Solution {
    public int search(int[] nums, int target) 
    {
        int ln = nums.length;
        int left=0;
        int right=ln-1;
        int res = -1;

        while(left<=right)
        {
            if(nums[left] == target)
            {
                return left;
            }
            else if(nums[right] == target)
            {
                return right;
            }
            left++;
            right--;
        }   

        return res; 
    }
}