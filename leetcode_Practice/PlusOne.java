class Solution {
    public int[] plusOne(int[] digits) 
    {
        int ln = digits.length;

        int left=0;
        int right=ln-1;
        int leftRange = ln/2;
        int rightRange = leftRange + 1;

        int sizeION = 0;
        int arrSize=ln;


        while(left<=leftRange)
        { 
            if(digits[left] == 9)
            {
                sizeION++;
            }

            if(right>=rightRange)
            {
                if(digits[right] == 9)
                {
                    sizeION++;
                }
            }

            left++;
            right--;
        }

        
        // System.out.println(ln);
        // System.out.println(sizeION);

        if(ln == sizeION)
        {
            arrSize = ln + 1;
        }

        int res[] = new int[arrSize];

        if(ln == sizeION)
        {
            res[0] = 1;
            for(int i=1; i<arrSize;i++)
            {
               res[i] = 0;
            }
        }

        else
        {
            int c=1;
            int remainder=1;
            int lastValue=0;
            for(int i=ln-1; i>=0; i--)
            {
                if(c == 1)
                {
                   lastValue = digits[i] + 1;
                   remainder = lastValue % 10; 
                   if(lastValue == 10)
                   {
                    res[i] = 0;
                   } 
                   else
                   {
                    res[i] = lastValue;
                   }
                    c=0;
                }

                else if(remainder == 0)
                {
                   lastValue = digits[i] + 1;
                   remainder = lastValue % 10; 
                   if(lastValue == 10)
                   {
                    res[i] = 0;
                   } 
                   else
                   {
                    res[i] = lastValue;
                   }
                }

                else
                {
                    res[i] = digits[i];
                }
            }
        }

        

        return res;
    }
}