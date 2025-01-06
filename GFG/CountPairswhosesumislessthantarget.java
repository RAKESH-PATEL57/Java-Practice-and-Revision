package GFG;

import java.util.Arrays;

public class CountPairswhosesumislessthantarget {
     int countPairs(int arr[], int target)
    {
        Arrays.sort(arr);

        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right)
        {
            int sum = arr[left] + arr[right];

            if (sum < target)
            {
                count += (right - left);
                left++;
            }
            else 
            {
                right--;
            }
        }

        return count;
    }
}
