package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairclosesttotarget {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int i=0,j=arr.length-1,diff=Integer.MAX_VALUE,first=-1,second=-1;
        List<Integer> ans = new ArrayList<>();
        
        while(i<j)
        {
            int sum = arr[i]+arr[j];
            if((diff>Math.abs(sum-target)) || ((diff==Math.abs(sum-target)) && arr[j]-arr[i]>second-first))
            {
                first=arr[i];
                second=arr[j];
                diff=Math.abs(sum-target);
            }
            if(sum<=target)i++;
            else j--;
        }
        if(first==-1 && second==-1)return ans;
        ans.add(first);
        ans.add(second);
        return ans;
    }
}


