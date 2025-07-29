package GFG;

import java.util.ArrayList;

public class ASCIIRangeSum {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        int[] firstPos = new int[26];
        int[] lastPos = new int[26];

        for (int i = 0; i < 26; i++) {
            firstPos[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';

            if (firstPos[charIndex] == -1) {
             
                firstPos[charIndex] = i;
            }
       
            lastPos[charIndex] = i;
        }

       
        for (int i = 0; i < 26; i++) {
            if (firstPos[i] != -1 && firstPos[i] != lastPos[i]) {
                
                int sum = 0;
                for (int j = firstPos[i] + 1; j < lastPos[i]; j++) {
                    sum += (int) s.charAt(j);
                }

                if (sum > 0) { 
                    result.add(sum);
                }
            }
        }

        return result;
    }
}
