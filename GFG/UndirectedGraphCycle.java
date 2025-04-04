package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycle {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCheckCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsCheckCycle(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, -1 }); // {node, parent}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int node = front[0];
            int parent = front[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[] { neighbor, node });
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
