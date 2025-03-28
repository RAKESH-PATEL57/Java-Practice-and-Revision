package GFG;

import java.util.PriorityQueue;

public class ActivitySelection {
     static int activitySelection(int[] start, int[] finish)
    {
        int n = start.length;
        int ans = 0;

        // Min Heap to store activities in ascending order
        // of finish time
        PriorityQueue<int[]> p = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            p.add(new int[] { finish[i], start[i] });
        }

        // Variable to store the end time of the last
        // selected activity
        int finishtime = -1;

        while (!p.isEmpty()) {
            int[] activity
                = p.poll(); // Extract the activity with the
                            // smallest finish time
            if (activity[1] > finishtime) {
                finishtime = activity[0];
                ans++;
            }
        }

        return ans;
    }
}
