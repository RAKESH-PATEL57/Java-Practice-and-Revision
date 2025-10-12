import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++)
        {
            // increase frequency of current number
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // if current number's frequency > k, move left pointer
            while (freq.get(nums[right]) > k)
            {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            // update max length of valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
