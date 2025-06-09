package GFG;

public class RowWithMax1s {
    //method - 1 time complexity --> O(n*m)
    public int rowWithMax1s(int arr[][]) {
        // code here
        int rlen = arr.length;
        int clen = arr[0].length;
        int res = -1;
        
        int tempSum = 0;
        int sum=0;
        
        for(int i=0;i<rlen;i++)
        {
            for(int j=0;j<clen;j++)
            {
                if(arr[i][j] == 1)
                {
                  tempSum += 1;
                }
            }
            
            if(tempSum > sum)
            {
                res = i;
                sum = tempSum;
            }
            
            
            // System.out.println(sum + " " + res);
           
            
            tempSum = 0;
        }
        
        
        return res;
        
    }

    //method - 2 time complexity --> O(n+m)
    public int rowWithMax1s(int arr[][]) {
       
        int rlen = arr.length;
        int clen = arr[0].length;
        int maxRowIndex = -1;
        int j = clen - 1; 
    
        for (int i = 0; i < rlen; i++) 
        {
            while (j >= 0 && arr[i][j] == 1) 
            {
                j--;
                maxRowIndex = i;
            }
        }
        
        return maxRowIndex;
        
    }
}
