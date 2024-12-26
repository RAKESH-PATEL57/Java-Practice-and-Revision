package GFG;

public class SearchinRotatedSortedArray {
    int search(int[] arr, int key) 
    {
        int ln = arr.length;
        int left=0;
        int right=ln-1;
        int res = -1;

        while(left<=right)
        {
            if(arr[left] == key)
            {
                return left;
            }
            else if(arr[right] == key)
            {
                return right;
            }
            left++;
            right--;
        }   
       

        return res; 
    }
}
