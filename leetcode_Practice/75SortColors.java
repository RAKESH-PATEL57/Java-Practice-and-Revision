class Solution {
    public void sortColors(int[] nums) 
    {
        int ln = nums.length;
        int zero = 0; 
        int one = 0; 
        int two = 0; 

        for(int i=0;i<ln;i++)
        {
            if(nums[i] == 0)
            {
                zero++;
            }
            else if(nums[i] == 1)
            {
                one++;
            }
            else
            {
                two++;
            }
        }

        int c=0;

        while(zero>0)
        {
            nums[c++] = 0;
            zero--;
        }
        while(one>0)
        {
            nums[c++] = 1;
            one--;
        }
        while(two>0)
        {
            nums[c++] = 2;
            two--;
        }
        
    }
}


// second approach
class Solution {
    /*
  Dutch National Flag problem solution.
  */
    public void sortColors(int[] nums) {
        // For all idx < i : nums[idx < i] = 0
        // j is an index of elements under consideration
        int p0 = 0, curr = 0;

        // For all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // Swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // Swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }
}