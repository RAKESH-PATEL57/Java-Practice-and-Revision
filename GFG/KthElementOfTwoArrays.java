package GFG;

public interface KthElementOfTwoArrays {
    public int kthElement(int a[], int b[], int k) 
    {
        int c=0;
        
        int ln1 = a.length;
        int ln2 = b.length;
        
        int p1=0;
        int p2=0;
        int res = 0;
        
        while(p1<ln1 && p2<ln2)
        {
            if(a[p1] > b[p2])
            {
                res = b[p2];
                p2++; 
            }
            else
            {
                res = a[p1];
                p1++;               // 1 2 3 4 6 7
            }
            
            c++;
            if(c == k)
            {
                return res;
            }
        }
        
        while (p1 < ln1) 
        {
            res = a[p1];
            p1++;
            c++;
            if (c == k) 
            {
                return res;
            }
        }
        
        while (p2 < ln2) 
        {
            res = b[p2];
            p2++;
            c++;
            if (c == k) 
            {
                return res;
            }
        }
        
        return -1;
        
        
    }
}
