package GFG;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementInCircularArray {
    int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        
        // Initialize result with -1 for all positions
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        
        // Stack to store indices of elements
        Stack<Integer> stack = new Stack<>();
        
        // Process all elements twice to handle circular array
        for (int i = 0; i < 2 * n; i++) {
            int circularIndex = i % n;
            
            // While stack is not empty and current element is greater than element at stack top
            while (!stack.isEmpty() && arr[circularIndex] > arr[stack.peek()]) 
            {
                result.set(stack.pop(), arr[circularIndex]);
            }
            
            // Only push indices from the first pass
            if (i < n) {
                stack.push(circularIndex);
            }
        }
        
        return result;
}
