package GFG;

public class NineDivisors {
    public static int countNumbers(int n) {

        int count = 0;

        for (int num = 1; num <= n; num++) {
            if (countDivisors(num) == 9) {
                count++;
            }
        }

        return count;
    }

    private static int countDivisors(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                // If divisors are equal, count only one
                if (num / i == i) {
                    count++;
                } else {
                    // Otherwise count both divisors
                    count += 2;
                }
            }
        }

        return count;
    }
}
