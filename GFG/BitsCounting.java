package GFG;

import java.util.ArrayList;

public class BitsCounting {
    public static ArrayList<Integer> countBits(int n) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<=n;i++)
        {
            String strNum = Integer.toBinaryString(i);
            int sum = 0;
            
            for( char c: strNum.toCharArray())
            {
                if(c == '1')
                {
                    sum++;
                }
            }
            
            res.add(sum);
        }
        return res;
        
    }
}
