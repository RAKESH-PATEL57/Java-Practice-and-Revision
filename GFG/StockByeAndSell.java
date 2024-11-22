package GFG;

public class StockByeAndSell 
{
    public int maximumProfit(int prices[]) 
    {
        int ln = prices.length;
        
        int profit = 0;
        int comp = prices[0];
        
        for(int i=1; i<ln; i++)
        {
            if(prices[i] > comp)
            {
                
                profit = profit + prices[i] - comp;
                comp = prices[i];
            }
            else
            {
                comp = prices[i];
            }
        }
        
        return profit;
    }
    
    //or
    public int maximumProfit(int prices[]) 
    {
        int ln = prices.length;
        
        int profit = 0;
        
        for(int i=1; i<ln; i++)
        {
            if(prices[i] > prices[i-1])
            {
                profit = profit + prices[i] - prices[i-1];
            }
        }
        
        return profit;
    }    
}
