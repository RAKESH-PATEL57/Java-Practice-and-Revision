package GFG;

public class LCMTriplet {
    int lcmTriplets(int n) {
        // code here
        if (n < 3) return n; // If n is less than 3, just return n (since we can't pick 3 numbers)
        
        // If n is odd, pick n, n-1, n-2
        if (n % 2 != 0) {
            return n * (n - 1) * (n - 2);
        } else {
            // If n is even and n%3!=0, pick n, n-1, n-3
            if (n % 3 != 0) {
                return n * (n - 1) * (n - 3);
            } else {
                // If n is even and divisible by 3, pick n-1, n-2, n-3
                return (n - 1) * (n - 2) * (n - 3);
            }
        }
    }
}
