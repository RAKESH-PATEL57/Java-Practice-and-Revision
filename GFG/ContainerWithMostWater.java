package GFG;

public class ContainerWithMostWater {
    public int maxWater(int arr[]) {
        int s = 0, e = arr.length - 1;
        int maxArea = 0;
    
        while (s < e) 
        {
            int area = Math.min(arr[s], arr[e]) * (e - s);
            maxArea = Math.max(maxArea, area);
    
            if (arr[s] < arr[e]) 
            {
                s++;
            } 
            else 
            {
                e--;
            }
        }
    
        return maxArea;
        }
}
