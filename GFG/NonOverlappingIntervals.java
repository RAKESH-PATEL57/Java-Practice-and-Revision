package GFG;

import java.util.Arrays;

public class NonOverlappingIntervals {
    //methode one
    static int minRemoval(int intervals[][]) 
    {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int last = 0,ans=0,n=intervals.length;
        for(int i=1;i<n;i++){
            if(intervals[i][0] >= intervals[last][1])
            {
                last=i;
            }
            
            else{
              ans++;
            }
        }
        return ans;
    }

     //modififation
     static int minRemoval(int intervals[][]) 
    {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int last = 0,ans=0,n=intervals.length;
        for(int i=1;i<n;i++){
            if(intervals[i][0]<intervals[last][1])ans++;
            else last=i;
        }
        return ans;
    }

}
