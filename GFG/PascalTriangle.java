package GFG;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        List<List<Integer>> mat = printPascal(n);
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=mat.size()-1;i<mat.size();i++)
        {
            for(int j=0;j<mat.get(i).size();j++)
            {
                res.add(mat.get(i).get(j));
            }
            
        }
        
        return res;
    }
    
    
     static List<List<Integer>> printPascal(int n) 
     {
        List<List<Integer>> mat = new ArrayList<>();

        for (int row = 0; row < n; row++) {
          
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
                
                if (row == i || i == 0)
                {
                    arr.add(1);
                }
                  
                else
                {
                    
                    arr.add(mat.get(row - 1).get(i - 1) + mat.get(row - 1).get(i));
                }
            }
            mat.add(arr);
        }
        return mat;
    }

}
