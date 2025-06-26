package GFG;

import java.util.Collections;
import java.util.PriorityQueue;

public class GameWithString {
    public int minValue(String s, int k) {
        // code here
        int[] freq = new int[26]; // assuming lowercase alphabets only
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Create a max heap of frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }
        
        // Remove k characters
        while (k > 0) {
            int highestFreq = maxHeap.poll();
            highestFreq--;
            if (highestFreq > 0) {
                maxHeap.add(highestFreq);
            }
            k--;
        }
        
        // Calculate the final value
        int value = 0;
        while (!maxHeap.isEmpty()) {
            int f = maxHeap.poll();
            value += f * f;
        }
        
        return value;
    }
}
