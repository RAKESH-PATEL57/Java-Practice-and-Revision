package GFG;
import java.util.ArrayList;
public class LeftViewOfBinaryTree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        recLeftView(root, 0, result);
        return result;
    }
    
     private static void recLeftView(Node root, int level, ArrayList<Integer> result) {
        if (root == null) return;
        
        if (level == result.size()) {
            result.add(root.data);
        }
        
        recLeftView(root.left, level + 1, result);
        recLeftView(root.right, level + 1, result);
    }
}
