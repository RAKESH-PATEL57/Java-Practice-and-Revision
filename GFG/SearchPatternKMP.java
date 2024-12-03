package GFG;

import java.util.ArrayList;

public class SearchPatternKMP {

    void  computeLPS(String pat,int[] lps, int m)
    {
        int i=1;
        int j=0;
        
        while(i < m)
        {
            if(pat.charAt(i) == pat.charAt(j))
            {
                lps[i] = j+1;
                ++j;
                ++i;    
            }
            else
            {
                if(j != 0)
                {
                    j = lps[j - 1];
                }
                else
                {
                    lps[i] = 0;
                    ++i;
                }
            }
        }
    }

    ArrayList<Integer> search(String pat, String txt) 
    {
        int n= txt.length();
        int m= pat.length();
        
        int[] lps = new int[m];
        computeLPS(pat, lps, m);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int  i = 0;
        int  j = 0;
        
        while(i<n)
        {
            if(txt.charAt(i) == pat.charAt(j))
            {
                ++i;
                ++j;
            }
            else
            {
                if(j != 0)
                {
                    j = lps[j - 1];
                }
                else
                {
                    ++i;
                }
            }
            
            if(j == m)
            {
                res.add(i - j);
                j= lps[j - 1];
            }
        }
        
        
        return res;
        
        
    }
    
}
