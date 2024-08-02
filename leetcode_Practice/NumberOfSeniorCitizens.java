public class NumberOfSeniorCitizens 
{
    class Solution {
    public int countSeniors(String[] details) 
    {
        int count=0;
       for(int i=0; i<details.length ;i++)
       {
         String res = details[i];
      
         int age1 = Integer.parseInt(String.valueOf(res.charAt(11)));
         int age2 = Integer.parseInt(String.valueOf(res.charAt(12)));
        //  System.out.print(age1);
        //  System.out.println(" " + age2);
         if(age1 >= 6)
         {
            if((age1 > 6) || (age2 > 0))
            {
               count++;
            }
         
         }
         
       }


       return count;    
    }
}    
}
