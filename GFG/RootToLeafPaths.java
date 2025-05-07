package GFG;

import java.util.ArrayList;

public class RootToLeafPaths {
    static void rootLeaf(Node node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> result)
    {
        // Base case: null node
        if (node == null) return;
        
        // Add current node value
        currentPath.add(node.data);
        
        // If leaf node, add the current path to result
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Only make recursive calls if needed
            if (node.left != null) {
                rootLeaf(node.left, currentPath, result);
            }
            if (node.right != null) {
                rootLeaf(node.right, currentPath, result);
            }
        }
        
        // Backtrack - remove the last element from path
        currentPath.remove(currentPath.size() - 1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) return res;
        
        ArrayList<Integer> path = new ArrayList<>();
        
        rootLeaf(root, path, res);
        
        return res;
    }
}
