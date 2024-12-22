package GFG;

import java.util.ArrayList;

public class SpirallyTraversingAMatrix {
      public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int left = 0;                   // 4 pointer approach 😊
        int top = 0;
        int right = mat[0].length - 1;
        int bottom = mat.length - 1;
        int dir = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(left <= right && top <= bottom)
        {
            if(dir == 0)
            {
                for(int i = left; i <= right; ++i)
                {
                    res.add(mat[top][i]);
                }
                ++top;
            }
            else if(dir == 1)
            {
                for(int i = top; i <= bottom; ++i)
                {
                    res.add(mat[i][right]);
                }
                --right;
            }
            else if(dir == 2)
            {
                for(int i = right; i >= left; --i)
                {
                    res.add(mat[bottom][i]);
                }
                --bottom;
            }
            else
            {
                for(int i = bottom; i >= top; --i)
                {
                    res.add(mat[i][left]);
                }
                ++left;
            }
            dir = (dir + 1) % 4;
        } 
        return res;
    }
}
