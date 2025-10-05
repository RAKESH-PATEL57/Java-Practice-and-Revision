public class FindFirstAndLastPositionOfElementInSortedArray {
     public int[] searchRange(int[] nums, int target) 
    {
        int ln = nums.length;
        int i;
        int arr[]= new int[2];
        arr[0]=-1;
        arr[1]=-1;

        if(ln == 0)
        {
            return arr;
        }

        int left=0;
        int right=ln-1;

        while(left<=right)
        {
           if(nums[left] == target)
           {
            arr[0] = left;
           }
           else
           {
            left++;
           }
           if(nums[right] == target)
           {
            arr[1] = right;
           }
           else
           {
            right--;
           }

           if((arr[0] != -1) && (arr[1] != -1))
           {
            break;
           }
        }

        return arr;

    }
}
