class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int stock = prices[i];
            for(int j = i + 1; j < n; j++){
                if(stock > prices[j]) continue;
                int profit = prices[j] - stock;
                max = Math.max(max, profit); 
            }
        }
        return max;
    }
}
