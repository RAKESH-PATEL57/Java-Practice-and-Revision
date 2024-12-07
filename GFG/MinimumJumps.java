package GFG;

public class MinimumJumps 
{
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
}
