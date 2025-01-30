public class MajorityElement {
    static int majorityElement(int arr[]) 
    {
      int candidate = arr[0], count = 1;
    
      // Phase 1: Find a potential majority element
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] == candidate) 
            {
                count++;
            } else 
            {
                count--;
                if (count == 0)
                {
                    candidate = arr[i];
                    count = 1;
                }
            }
        }
    
        // Phase 2: Verify if the candidate is a majority element
        count = 0;
        for (int num : arr) 
        {
            if (num == candidate) 
            {
                count++;
            }
        }
        
        return count > arr.length / 2 ? candidate : -1;
    }
}
