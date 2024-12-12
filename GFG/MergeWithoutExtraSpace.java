package GFG;

public class MergeWithoutExtraSpace 
{
    public void mergeArrays(int a[], int b[]) 
    {
        int n = a.length;
        int m = b.length;
        int p1=0;
        int p2=0;
        
        while(p1<n)
        {
           
            if(a[p1] <= b[p2])
            {
               p1++;
            }
            else
            {
                int temp = a[p1];
                a[p1] = b[p2];
                b[p2] = temp;
                
                int current = b[p2];
                int j = p2+1;
                
                while( j < m && b[j] < current)
                {
                    b[j-1] = b[j];
                    j++;
                }
                
                b[j-1] = current;
                
                
                p1++;
              
            }
        }
        
    }
}
