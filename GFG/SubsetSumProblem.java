package GFG;

public class SubsetSumProblem {
    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        // Mark prev[0] = true as it is true to
        // make sum = 0 using 0 elements
        prev[0] = true;

        // Fill the subset table in bottom-up
        // manner
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    curr[j] = prev[j];
                }
                else {
                    curr[j]
                        = prev[j] || prev[j - arr[i - 1]];
                }
            }

            // Update prev to be the current row
            System.arraycopy(curr, 0, prev, 0, sum + 1);
        }
        return prev[sum];
    }
}
