public class NumberComplement {
    public int findComplement(int num) 
    {
       String val = Integer.toBinaryString(num);
       String comp = "";

       for(int i=0;i<val.length();i++)
       {
          if(val.charAt(i) == '0')
          {
            comp += "1";

          }
          else
          {
            comp += "0";
          }
       }

       int ans = Integer.parseInt(comp,2);
       
       return ans;    
    }
}
