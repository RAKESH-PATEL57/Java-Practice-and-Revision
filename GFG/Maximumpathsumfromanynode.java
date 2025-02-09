package GFG;

public class MaximumPathSumFromAnyNode {
    int findMaxSum(Node node) {
        // your code goes here
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(node, res);
        return res[0];
    }
    
    int dfs(Node node, int[] res){
        if(node == null){
            return 0;
        }
        
        int l = dfs(node.left, res);
        int r = dfs(node.right, res);
        int temp = Math.max(Math.max(l, r) + node.data, node.data);
        int ans = Math.max(l + r + node.data, temp);
        res[0] = Math.max(res[0], ans);
        return temp;
    }
}
