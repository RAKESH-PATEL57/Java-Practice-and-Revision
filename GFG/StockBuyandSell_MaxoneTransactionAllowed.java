package GFG;

public class StockBuyandSell_MaxoneTransactionAllowed 
{
    public int maximumProfit(int prices[]) 
    {
        int ln = prices.length;
        int minValue = prices[0];
        int maxProfit = 0;
        int temp = 0;
        
        for(int i=1;i<ln;i++)
        {
            if(prices[i] < minValue)
            {
                minValue = prices[i];
            }
            else
            {
                temp = prices[i] - minValue;
                if(temp > maxProfit)
                {
                   maxProfit = prices[i] - minValue;
                }
            }
        }
        
        return maxProfit;
        
    }       
}
