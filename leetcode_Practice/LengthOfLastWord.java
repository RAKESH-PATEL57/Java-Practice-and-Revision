public class LengthOfLastWord {
    public int lengthOfLastWord(String s) 
    {
        int count = 0;

        StringBuilder temp = new StringBuilder(s.trim());

        int ln = temp.length();
        
        for(int i=ln-1;i>=0;i--)
        {
            if(temp.charAt(i) == ' ')
            {
               return count;
            }
            else
            {
                count++;
            }
        }
        return count;    
    }
}
