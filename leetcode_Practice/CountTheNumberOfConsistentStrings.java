public class CountTheNumberOfConsistentStrings {
     public int countConsistentStrings(String allowed, String[] words) {
        
        int res = 0;

        for(int i=0;i<words.length;i++)
        {
            String temp = words[i].toString();
            boolean present = true;

            for(int j=0;j<temp.length();j++)
            {
                String check = "" + temp.charAt(j);
                if(!allowed.contains(check))
                {
                    present = false;
                    break;
                }
            }

            if(present == true)
            {
                res++;
            }

        }


        return res;

    }
}
