public class MinAndMaxInArray {

    //*******************/  approach - 1 /******************************
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min = arr[i];
            }
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        
        Pair<Integer,Integer> res = new Pair<Integer,Integer>(min,max);
        
        return res;
    } 

    //*******************/  approach - 2 /******************************
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        
        int p1=0;
        int p2=arr.length-1;
        
        while(p1<=p2)
        {
            if(arr[p1]<min)
            {
                min = arr[p1];
            }
            
            if(arr[p1]>max)
            {
                max = arr[p1];
            }
            
            if(arr[p2]<min)
            {
                min = arr[p2];
            }
            
            if(arr[p2]>max)
            {
                max = arr[p2];
            }
            
            p1++;
            p2--;
        }
        
        Pair<Integer,Integer> res = new Pair<Integer,Integer>(min,max);
        
        return res;
    }
}
