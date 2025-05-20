package GFG;

public class ElementWithLeftSideSmallerAndRightSideGreater {
    public int findElement(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        for (int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        int rightMin = arr[n - 1];

        for (int i = n - 2; i > 0; i--) 
        {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin) 
            {
                return arr[i];
            }

            rightMin = Math.min(rightMin, arr[i]);
        }
        return -1;
    }
}
