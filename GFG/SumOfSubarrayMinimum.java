package GFG;

import java.util.Stack;

public class SumOfSubarrayMinimum {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        long res = 0;
        int mod = (int)1e9 + 7;
        Stack<Integer> stack = new Stack<>();
        
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        
        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            res = (res + (arr[i] * left * right) % mod) % mod;
        }
        
        return (int)res;
    }
}
