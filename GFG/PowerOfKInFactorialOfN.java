package GFG;

public class PowerOfKInFactorialOfN {
    public int maxKPower(int n, int k) {
        // code here
        if (k == 1) {
            return n;  // Special case: 1^n always divides n!
        }
        
        int result = Integer.MAX_VALUE;
        int originalK = k;
        
        // Find prime factorization of k
        for (int factor = 2; factor * factor <= originalK; factor++) {
            if (originalK % factor == 0) {
                // Count how many times this factor appears in k
                int factorPower = 0;
                while (originalK % factor == 0) {
                    originalK /= factor;
                    factorPower++;
                }
                
                // Calculate how many times this prime appears in n!
                int count = 0;
                for (int i = factor; i <= n; i *= factor) {
                    count += n / i;
                }
                
                // We need count/factorPower as our answer (integer division)
                result = Math.min(result, count / factorPower);
            }
        }
        
        // If originalK is still > 1, it's a prime number itself
        if (originalK > 1) {
            int count = 0;
            for (int i = originalK; i <= n; i *= originalK) {
                count += n / i;
            }
            result = Math.min(result, count);
        }
        
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}
