package GFG;

public class SortedandRotatedMinimum {
    public int findMin(int[] arr) {
        int p1=0;
        int p2=arr.length-1;
        int minNum = arr[0];
        
        if(arr.length % 2 == 0)
        {
            while(p1<p2)
            {
                if(arr[p1] < minNum)
                {
                    minNum = arr[p1];
                }
                if(arr[p2] < minNum)
                {
                    minNum = arr[p2];
                }
                
                // System.out.println(arr[p2]);
                p1++;
                p2--;
            }
        }
        
        else
        {
            int p1Length = arr.length/2;
            int p2Length = arr.length-p1Length;
            while(p1<=p1Length)
            {
                if(arr[p1] < minNum)
                {
                    minNum = arr[p1];
                }
                p1++;
            }
            while(p2>=p2Length)
            {
                if(arr[p2] < minNum)
                {
                    minNum = arr[p2];
                } 
                p2--;
            }
        }
        
        return minNum;
    }
}
