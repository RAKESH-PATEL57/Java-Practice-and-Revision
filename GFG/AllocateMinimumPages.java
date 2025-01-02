
public enum AllocateMinimumPages {
    public static int findPages(int[] arr, int k) 
    {
        int ln = arr.length;

        if (k > ln) 
        {
            return -1;
        }
        
        int maxPages = 0;
        int sumPages = 0;
    
        for (int pages : arr)
        {
            maxPages = Math.max(maxPages, pages); 
            sumPages += pages;                  
        }
    
        int low = maxPages;
        int high = sumPages;
        int result = Integer.MAX_VALUE;
    
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
    
            if (isFeasible(arr, ln, k, mid)) 
            {
                result = mid;
                high = mid - 1; 
            } 
            else 
            {
                low = mid + 1; 
            }
        }
    
        return result;
    }
    
    private static boolean isFeasible(int[] arr, int ln, int k, int maxPages) 
    {
        int studentsRequired = 1; // Start with the first student
        int currentSum = 0;

        for (int pages : arr) 
        {
            if (currentSum + pages > maxPages)
            {
                
                studentsRequired++;
                currentSum = pages;
    
                // If more students are required than available, return false
                if (studentsRequired > k) 
                {
                    return false;
                }
            }
            else 
            {
                currentSum += pages;
            }
        }

        return true;
    }
}
