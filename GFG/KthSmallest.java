package GFG;

import java.util.ArrayList;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {

        // int maxElement = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        // int maxElement = Arrays.stream(arr).max();

        int maxElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        int[] frequency = new int[maxElement + 1];
        ArrayList<Integer> sortedArray = new ArrayList<>();

        for (int num : arr) {
            frequency[num]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i] > 0) {
                sortedArray.add(i);
                frequency[i]--;
            }
        }

        // System.out.println(sortedArray);

        return sortedArray.get(k - 1);

        // [2 3 4 1] k = 3

        // [0 0 0 0 0]

        // 1 2 3 4
        // [0 0 1 0 0] [0 0 1 1 0] [0 0 1 1 1] [0 1 1 1 1]

        // [0 1 1 1 1]
        // [0 1 2 3 4]

        // [1 2 3 4]

    }
}
