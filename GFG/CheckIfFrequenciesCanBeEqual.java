package GFG;

import java.util.HashMap;
import java.util.Map;

public class CheckIfFrequenciesCanBeEqual {
    boolean sameFreq(String s) {
        int[] freq = new int[26]; // Only lowercase alphabets
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Count occurrences of each frequency
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int f : freq) {
            if (f > 0) {
                freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
            }
        }
        
        // If all characters already have the same frequency
        if (freqCount.size() == 1) {
            return true;
        }
        
        // If there are more than 2 different frequencies, impossible to make equal with one removal
        if (freqCount.size() > 2) {
            return false;
        }
        
        // We have exactly 2 different frequencies
        int freq1 = 0, freq2 = 0, count1 = 0, count2 = 0;
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            if (freq1 == 0) {
                freq1 = entry.getKey();
                count1 = entry.getValue();
            } else {
                freq2 = entry.getKey();
                count2 = entry.getValue();
            }
        }
        
        // Case 1: If one frequency is 1 and it occurs only once
        if (freq1 == 1 && count1 == 1) {
            return true;
        }
        
        if (freq2 == 1 && count2 == 1) {
            return true;
        }
        
        // Case 2: If the difference between frequencies is 1 and the higher frequency occurs only once
        if (freq1 > freq2 && freq1 - freq2 == 1 && count1 == 1) {
            return true;
        }
        
        if (freq2 > freq1 && freq2 - freq1 == 1 && count2 == 1) {
            return true;
        }
        
        return false;
    }
}
