package GFG;

public class ClosestNeighbourInBST {
    public int findMaxFork(Node root, int k) {
        if (root == null) return -1;
        if (root.data == k) return k;
        else if (root.data < k) 
        {
            int x = findMaxFork(root.right, k);
            if (x == -1)
                return root.data;
            else
                return x;
        }
        return findMaxFork(root.left, k);
    }
}
