public class FindCommonElementsBetweenTwoArrays {
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
}
