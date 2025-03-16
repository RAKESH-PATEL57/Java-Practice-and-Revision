package GFG;

import java.util.Arrays;

public class MinimumJumps 
{

    //approach - 1
    static int minJumps(int[] arr) 
    {
        if(arr[0]==0)return -1;
        int ans = 1, jump = arr[0], mx = 0;
        for(int i=1;i<arr.length;i++){
            mx--;
            jump--;
            mx=Math.max(mx,arr[i]);
            if(jump==0 && i!=arr.length-1){
                if(mx<=0)return -1;
                jump=mx;
                mx=0;
                ans++;
            }
        }
        return ans;
    } 
    // approach - 2
     static int minJumps(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + arr[i] && j < n; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        if (dp[0] == Integer.MAX_VALUE)
            return -1;

        return dp[0];
    }
}
