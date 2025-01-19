public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
{
   int ln = candies.length;
   int maxCandy = candies[0];

   ArrayList<Boolean> res = new ArrayList<>();

   for(int i=1;i<ln;i++)
   {
       if(candies[i] > maxCandy)
       {
         maxCandy = candies[i];
       }
   }

   for(int i=0;i<ln;i++)
   {
       int sum = candies[i] + extraCandies;
       boolean temp = (sum >= maxCandy) ? true : false;
       res.add(temp);
   }
   
   return res;  
}