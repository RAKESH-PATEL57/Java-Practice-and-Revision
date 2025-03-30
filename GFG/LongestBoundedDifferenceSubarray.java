package GFG;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LongestBoundedDifferenceSubarray {

    // approach-1
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {

        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        int n = arr.length, start = 0, end = 0;

        int resStart = 0, resEnd = 0;
        while (end < n) {

            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();

            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();

            minQueue.addLast(end);
            maxQueue.addLast(end);

            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {

                if (start == minQueue.peekFirst())
                    minQueue.pollFirst();
                if (start == maxQueue.peekFirst())
                    maxQueue.pollFirst();
                start += 1;
            }
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);

        return res;
    }

    // approach-2

    static ArrayList<Integer> longestSubarray(int[] arr, int x) {

        // Monotonic Queue to store maximum and minimum elements
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        // Pointers to mark the range of current subarray
        int n = arr.length, start = 0, end = 0;

        // Pointers to mark the range of maximum subarray
        int resStart = 0, resEnd = 0;
        while (end < n) {

            // Pop the elements greater than current element
            // from min Queue
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();

            // Pop the elements smaller than current element
            // from max Queue
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();

            // Push the current index to both the queues
            minQueue.addLast(end);
            maxQueue.addLast(end);

            // Check if the subarray has maximum difference less
            // than X
            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {

                // Reduce the length of sliding window by moving
                // the start pointer
                if (start == minQueue.peekFirst())
                    minQueue.pollFirst();
                if (start == maxQueue.peekFirst())
                    maxQueue.pollFirst();
                start += 1;
            }

            // Maximize the subarray length
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

        // Return the longest sub-array
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);

        return res;
    }
}
