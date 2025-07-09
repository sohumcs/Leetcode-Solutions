class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            if(buy_price > prices[i]){
                buy_price = prices[i];
            }else{
                int temp_profit = prices[i] - buy_price;
                profit = Math.max(profit , temp_profit);
            }
        }
        return profit;
    }
}