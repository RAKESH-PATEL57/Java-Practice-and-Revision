package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofgraph {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0); // Start BFS from vertex 0
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsTraversal.add(node);
            
            // Traverse neighbors in given order
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return bfsTraversal;
        
    }
}
