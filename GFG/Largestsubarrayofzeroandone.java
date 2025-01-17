package GFG;

import java.util.HashMap;

public class Largestsubarrayofzeroandone {
     public int maxLen(int[] arr) 
    {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int n=arr.length,sum=0,ans=0;
        for(int i=0;i<n;i++){
            sum+=arr[i]==1?1:-1;
            if(sum==0){
                ans=i+1;
            }
            if(prefixSum.get(sum)!=null){
                ans=Math.max(ans,i-prefixSum.get(sum));
            }
            else{
                prefixSum.put(sum,i);
            }
        }
        return ans;
        
    }
}
