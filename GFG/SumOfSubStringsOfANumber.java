package GFG;

public class SumOfSubStringsOfANumber {
    public static int sumSubstrings(String s) {
        // code here
        int ln = s.length();
        
        int sum = 0;
        int place = 1;
        
        for(int i=ln-1;i>=0;i--)
        {
            int val = s.charAt(i) - '0';
            sum += (val * (i+1) * place);
            
            place = (place * 10) + 1;
        }
        
        return sum;
        
    }
}
