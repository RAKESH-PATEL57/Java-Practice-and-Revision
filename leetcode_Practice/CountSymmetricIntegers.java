public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) 
    {
        int res = 0;

        for(int i=low;i<=high;i++)
        {
            String temp = Integer.toString(i);
            if( (temp.length() % 2 )== 0)
            {

                int half = temp.length()/2;
                int sum1=0;
                int sum2=0;

                for(int j=0;j<half;j++)
                {
                    int ftemp = temp.charAt(j) - '0';
                    sum1 += ftemp;
                }
                for(int k=half;k<temp.length();k++)
                {
                    int stemp = temp.charAt(k) - '0';
                    sum2 += stemp;
                }

                if(sum1 == sum2)
                {
                    res++;
                }

            }
        }


        return res;
    }
}
