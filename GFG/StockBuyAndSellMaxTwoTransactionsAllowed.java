package GFG;

public class StockBuyAndSellMaxTwoTransactionsAllowed {
    static int maxProfit(int[] prices) {
        // Variables to store the maximum profit 
        // after the first and second transactions
        int firstBuy = Integer.MIN_VALUE;  
        int firstSell = 0;      
        int secondBuy = Integer.MIN_VALUE; 
        int secondSell = 0;      
        
        // Iterate over each day's stock prices
        for (int i = 0; i < prices.length; i++) {
            
            // Calculate maximum profit
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            secondSell = Math.max(secondSell, secondBuy + prices[i]);
        }
        
        // The result is the maximum 
        // profit after the second sell
        return secondSell;
    }
}
