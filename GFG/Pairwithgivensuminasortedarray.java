package GFG;

public class Pairwithgivensuminasortedarray {
    int countPairs(int arr[], int target) 
    {
        int p1 = 0;    
        int p2 = arr.length-1;
        int ans = 0;
        
        while(p1 < p2)
        {
            int sum = arr[p1]+arr[p2];
            if(sum == target)
            {
                if(arr[p1] == arr[p2])
                {
                    int n = p2-p1;
                    ans += (n * (n+1))/2;
                    break;
                }
                else
                {
                    int left=1,right=1;
                    while((p1<p2) && (arr[p1] == arr[p1+1]) )
                    {
                        left++;
                        p1++;
                    }
                    while((p1<p2) && (arr[p2] == arr[p2-1]) )
                    {
                        right++;
                        p2--;
                    }
                    ans += (left * right);
                    p1++;
                    p2--;
                }
            }
            else if(sum < target)
            {
                p1++;
            }
            else
            {
                p2--;
            }
            
        }
        
        return ans;
        
    }
}
