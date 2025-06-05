package GFG;

public class RotateArrayByOne {
    public void rotate(int[] arr) {
        // code here
        int p1=0;
        
        int ln = arr.length;
        
        
        if(ln>1)
        {
            int temp = arr[0];
            
            arr[0] = arr[ln-1];
            
            for(int i=1;i<ln;i++)
            {
                int temps = arr[i];
                arr[i] = temp;
                temp=temps;
            }
            
        }
    }
}
