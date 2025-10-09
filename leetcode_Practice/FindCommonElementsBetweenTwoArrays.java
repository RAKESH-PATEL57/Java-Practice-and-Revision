import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays {


    //method-1 (Brute Force)
    public int[] findIntersectionValues(int[] nums1, int[] nums2) 
    {
        // Map<Integer,Integer> n1 = new HashMap<>();
        // Map<Integer,Integer> n2 = new HashMap<>();

        int ans1 = 0;    
        int ans2 = 0;    
        int res[] = new int[2];

        // for(int i=0;i<nums1.length;i++)
        // {
        //     n1.put(nums1[i],n1.getOrDefault(nums1[i], 0) + 1);
        // }

        // for(int i=0;i<nums2.length;i++)
        // {
        //     n2.put(nums2[i],n1.getOrDefault(nums2[i], 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry : n1.entrySet())
        // {
        //    
        // }

        

        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
               if(nums1[i] == nums2[j])
               {
                 ans1++;
                 break;
               }
            }
        }

        res[0] = ans1;

        for(int i=0;i<nums2.length;i++)
        {
            for(int j=0;j<nums1.length;j++)
            {
               if(nums2[i] == nums1[j])
               {
                 ans2++;
                 break;
               }
            }
        }

        res[1] = ans2;


        return res;
    }


    //method -2 (Using HashSet)
            // Use HashSet for O(1) average lookup
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add all elements to sets
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        int ans1 = 0;
        int ans2 = 0;

        // Count how many nums1[i] exist in nums2
        for (int num : nums1) {
            if (set2.contains(num)) ans1++;
        }

        // Count how many nums2[i] exist in nums1
        for (int num : nums2) {
            if (set1.contains(num)) ans2++;
        }

        return new int[]{ans1, ans2};
}
